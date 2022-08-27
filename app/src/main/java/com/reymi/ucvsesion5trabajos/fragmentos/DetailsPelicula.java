package com.reymi.ucvsesion5trabajos.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.reymi.ucvsesion5trabajos.R;
import com.reymi.ucvsesion5trabajos.modelo.Peliculas;

import java.util.ArrayList;
import java.util.List;

public class DetailsPelicula extends Fragment {

    View view;
    ArrayList<? extends Peliculas> listaPeliculas;
    TextView descripcion, titulo, detalles;

    public DetailsPelicula() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_details_pelicula, container, false);
        descripcion = view.findViewById(R.id.descripcion);
        titulo = view.findViewById(R.id.tvTitulo2);
        detalles = view.findViewById(R.id.detalles2);

        Bundle bundle = this.getArguments();

        listaPeliculas = bundle.getParcelableArrayList("ListaObjetos");
        int posicion = bundle.getInt("posicion");

        for (int i = 0; i < listaPeliculas.size(); i++) {
            titulo.setText(listaPeliculas.get(posicion).getNombre());
            detalles.setText(listaPeliculas.get(posicion).getDetalles());
            descripcion.setText(listaPeliculas.get(posicion).getDescripcion());
        }

        return view;
    }
}