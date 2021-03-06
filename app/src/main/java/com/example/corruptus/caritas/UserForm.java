package com.example.corruptus.caritas;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class UserForm extends AppCompatActivity {
    private EditText Nombre;
    private EditText Edad;
    private Spinner Tipo;
    private Spinner Genero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_form);
        this.Nombre = (EditText)findViewById(R.id.nombre);
        this.Edad = (EditText)findViewById(R.id.edad);
        this.Tipo = (Spinner)findViewById(R.id.tipo);
        this.Genero = (Spinner)findViewById(R.id.genero);
    }

    protected void click(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(UserForm.this);
        builder.setMessage(getResources().getString(R.string.mensaje_inicio)).setTitle("Acerca del estudio");
        builder.setPositiveButton("Acepto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
                Intent resultData = new Intent();
                if (Nombre.getText().toString().length() == 0) {
                    Nombre.setError("No puedes dejar este espacio vacío.");
                    return;
                }
                if (Edad.getText().toString().length() == 0) {
                    Edad.setError("No puedes dejar este espacio vacío.");
                    return;
                }
                resultData.putExtra("Nombre", Nombre.getText().toString());
                resultData.putExtra("Edad", Integer.parseInt(Edad.getText().toString()));
                resultData.putExtra("Tipo", Tipo.getSelectedItem().toString());
                resultData.putExtra("Genero", Genero.getSelectedItem().toString());
                setResult(MainActivity.RESULT_OK, resultData);
                finish();
            }
        });
        builder.setNegativeButton("No Acepto", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
