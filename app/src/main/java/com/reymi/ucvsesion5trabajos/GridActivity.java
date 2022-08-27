package com.reymi.ucvsesion5trabajos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.reymi.ucvsesion5trabajos.adapters.myAdapter;

import java.util.ArrayList;

public class GridActivity extends AppCompatActivity {

    ArrayList<String> peliculas;
    GridView gridView;
    com.reymi.ucvsesion5trabajos.adapters.myAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        gridView = (GridView) findViewById(R.id.gvI);
        peliculas = new ArrayList<>();

        peliculas.add("Estacion Zombie 2");
        peliculas.add("Proyecto Power");
        peliculas.add("Mision de Rescate");
        peliculas.add("Avengers: EndGame");
        peliculas.add("El Tunel");
        peliculas.add("El codigo del Miedo");
        peliculas.add("Mar abierto");
        peliculas.add("Origenes Secretos");
        peliculas.add("Hombres de negro");
        peliculas.add("Alerta en lo profundo 3");
        peliculas.add("Francotirador");
        peliculas.add("Ju-On: La maldicion");

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(GridActivity.this, "Hola que tal", Toast.LENGTH_SHORT).show();
            }
        });
        myAdapter = new myAdapter(getApplicationContext(), R.layout.grid_items, peliculas);
        gridView.setAdapter(myAdapter);
    }
}