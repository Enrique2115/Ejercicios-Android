package com.reymi.ucvsesion5trabajos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.reymi.ucvsesion5trabajos.fragmentos.DetailsPelicula;
import com.reymi.ucvsesion5trabajos.fragmentos.PeliculasFragment;

public class FragmentActivity extends AppCompatActivity {

    Fragment fragmentPelicula, fragmentDetailsPelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        fragmentPelicula = new PeliculasFragment();
        fragmentDetailsPelicula = new DetailsPelicula();

        getSupportFragmentManager().beginTransaction().add(R.id.containerFragment, fragmentPelicula).commit();

    }
}