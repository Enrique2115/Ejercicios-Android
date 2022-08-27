package com.reymi.ucvsesion5trabajos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.reymi.ucvsesion5trabajos.adapters.myAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView lvPelicula;
    Button btnAgregar;
    EditText inputPelicula;
    ArrayList<String> pelicula;
    com.reymi.ucvsesion5trabajos.adapters.myAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lvPelicula = (ListView) findViewById(R.id.lvPelicula);
        btnAgregar = (Button) findViewById(R.id.btnAgregarProd);
        inputPelicula = (EditText) findViewById(R.id.inputPelicula);
        pelicula = new ArrayList<>();
        myAdapter = new myAdapter(getApplicationContext(), R.layout.list_items, pelicula);
        pelicula.add("El Tunel");

        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pelicula.add(inputPelicula.getText().toString());
                //actualiza el listView por medio del metodo notifyDataSetChanged creado en myadapter
                myAdapter.notifyDataSetChanged();
                inputPelicula.setText("");

            }
        });

        myAdapter = new myAdapter(getApplicationContext(), R.layout.list_items, pelicula);
        lvPelicula.setAdapter(myAdapter);
    }
}