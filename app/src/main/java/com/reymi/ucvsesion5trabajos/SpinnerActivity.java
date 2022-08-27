package com.reymi.ucvsesion5trabajos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class SpinnerActivity extends AppCompatActivity {

    EditText inputNombre, inputApellidos;
    Spinner spEstado, spCargo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        inputNombre = findViewById(R.id.inputNombre);
        inputApellidos = findViewById(R.id.inputApellidos);
        spEstado = findViewById(R.id.spEstado);
        spCargo = findViewById(R.id.spCargo);

        String[] estado = {"Soltero", "Casado"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_items, estado);
        spEstado.setAdapter(adapter);

        String[] cargo = {"Ventas", "Marketing", "Informatica", "Administracion"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getApplicationContext(),
                R.layout.spinner_items, cargo);
        spCargo.setAdapter(adapter2);
    }
}