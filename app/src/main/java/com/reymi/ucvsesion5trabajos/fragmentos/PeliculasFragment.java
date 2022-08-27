package com.reymi.ucvsesion5trabajos.fragmentos;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.reymi.ucvsesion5trabajos.FragmentActivity;
import com.reymi.ucvsesion5trabajos.R;
import com.reymi.ucvsesion5trabajos.adapters.adapterRecycler;
import com.reymi.ucvsesion5trabajos.modelo.Peliculas;

import java.util.ArrayList;
import java.util.List;

public class PeliculasFragment extends Fragment {

    View view;
    List<Peliculas> listaPeliculas;
    RecyclerView recyclerView;
    DetailsPelicula detailsPelicula = new DetailsPelicula();
    Fragment fragment = new Fragment();
    Bundle bundle = new Bundle();

    public PeliculasFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_peliculas, container, false);

        initPeliculas();

        recyclerView = view.findViewById(R.id.peliculasRecycler);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);

        recyclerView.setAdapter(new adapterRecycler(listaPeliculas, new adapterRecycler.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //Toast.makeText(getContext(), "hola", Toast.LENGTH_LONG).show();
                try {
                    FragmentTransaction transaction2 = getActivity().getSupportFragmentManager().beginTransaction();
                    transaction2.replace(R.id.containerFragment, detailsPelicula);
                    transaction2.addToBackStack(null);
                    transaction2.commit();
                    bundle.putParcelableArrayList("ListaObjetos", (ArrayList<? extends Parcelable>) listaPeliculas);
                    bundle.putInt("posicion", position);
                    detailsPelicula.setArguments(bundle);
                } catch (Exception e) {
                    Log.d("fragment2", String.valueOf(e.getCause()));
                }

            }
        }));

        return view;
    }

    public void initPeliculas() {
        listaPeliculas = new ArrayList<Peliculas>();

        listaPeliculas.add(new Peliculas("El tunel", "Accion", 5, "En Noruega hay más de 1100 túneles. Pero, ¿qué pasa cuando ocurre un accidente dentro de uno de ellos? Esto es exactamente lo que sucede en vísperas de Navidad, cuando un camión se estrella y queda atrapado en un túnel, dejando a todos los transeúntes sin poder moverse. Con una tormenta de nieve en el exterior, y los rescatistas luchando por llegar al lugar del accidente, cada persona deberá luchar por encontrar una salida, antes de que sea demasiado tarde.", R.drawable.cinema));
        listaPeliculas.add(new Peliculas("Proyecto Power", "Accion", 5, "Comienza a correrse la voz por las calles de Nueva Orleans de una misteriosa pastilla nueva que le confiere superpoderes únicos a cada persona que la consume. ¿La trampa? No sabes qué puede pasar hasta que la tomas… Algunos adquieren una piel a prueba de balas, invisibilidad y fuerza sobrehumana, mientras que otros padecen una reacción más letal. Con la llegada de la pastilla, la tasa de delitos de la ciudad escala a niveles peligrosos, por lo que un policía local (Interpretado por Joseph Gordon-Levitt) se une a una traficante de drogas adolescente (Interpretado por Dominique Fishback) y a un exsoldado motivado por un plan de venganza secreto (Interpretado por Jamie Foxx) para enfrentar con poder al poder. Tanto es así, que se arriesgan a tomar la pastilla con el objetivo de encontrar y detener al grupo responsable de su elaboración.", R.drawable.cinema));
        listaPeliculas.add(new Peliculas("Mision de Rescate", "Accion, Aventura, Ciencia ficcion", 3, "Durante una misión a Marte de la nave tripulada Ares III, una fuerte tormenta se desata dando por desaparecido y muerto al astronauta Mark Watney (Matt Damon), sus compañeros toman la decisión de irse pero él ha sobrevivido. Está solo y sin apenas recursos en el planeta. Con muy pocos medios deberá recurrir a sus conocimientos, su sentido del humor y un gran instinto de supervivencia para lograr sobrevivir y comunicar a la Tierra que todavía está vivo esperando que acudan en su rescate.", R.drawable.cinema));
        listaPeliculas.add(new Peliculas("Avengers: EndGame", "Accion", 5, "Culminación de un universo de 22 películas interconectadas, la cuarta entrega de la saga Avengers invita al público a presenciar el momento decisivo de este viaje épico. Nuestros queridos héroes comprenderán por fin lo frágil que es esta realidad y los sacrificios que deberán hacer para defenderla.", R.drawable.cinema));
        listaPeliculas.add(new Peliculas("El codigo del Miedo", "Accion", 4.5, "Mei, una niña china que vive en los bajos fondos de Nueva York, tiene una mente prodigiosa para las matemáticas. Las triadas chinas, la mafia rusa e incluso la policía de NY la persiguen porque en su memoria guarda un código secreto de alta importancia para todos ellos. El destino hace que se cruce con Luke (Jason Stattham), un ex agente de élite que ha tocado fondo y se ha convertido en un fracasado. Juntos trazarán un plan para librarse de los perseguidores de la niña.", R.drawable.cinema));
        listaPeliculas.add(new Peliculas("Mar abierto", "Accion, Suspenso, Terror", 4, "Basada en una historia real ocurrida en Las Bahamas. Una pareja adicta al trabajo había decidido tomarse un tiempo de relax y pasar unos días buceando. La lancha que los lleva, debido a un descuido de la tripulación, los abandona en medio de un mar, a la deriva y lejos de la costa, en unas aguas infestadas de tiburones.", R.drawable.cinema));
        listaPeliculas.add(new Peliculas("Origenes Secretos", "Accion", 3.5, "", R.drawable.cinema));
        listaPeliculas.add(new Peliculas("Hombres de negro", "Accion", 1, "", R.drawable.cinema));
        listaPeliculas.add(new Peliculas("Alerta en lo profundo 3", "Accion, Terror", 1, "", R.drawable.cinema));
    }

}