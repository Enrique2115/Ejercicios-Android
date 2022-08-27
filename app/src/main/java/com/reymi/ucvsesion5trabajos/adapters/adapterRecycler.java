package com.reymi.ucvsesion5trabajos.adapters;

import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.reymi.ucvsesion5trabajos.R;
import com.reymi.ucvsesion5trabajos.modelo.Peliculas;

import java.util.List;

public class adapterRecycler extends RecyclerView.Adapter<adapterRecycler.PeliculasViewHolder> {

    private List<Peliculas> peliculas;
    private OnItemClickListener itemClickListener;

    public adapterRecycler(List<Peliculas> peliculas, OnItemClickListener itemClickListener) {
        this.peliculas = peliculas;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public PeliculasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);

        return new PeliculasViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculasViewHolder holder, int position) {
        holder.setPelicula(peliculas.get(position));
        holder.bind(itemClickListener);
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public static class PeliculasViewHolder extends RecyclerView.ViewHolder {

        TextView textTitulo, textDetalle;
        RatingBar ratingBar;
        ImageView imagePelicula;

        public PeliculasViewHolder(@NonNull View itemView) {
            super(itemView);

            textTitulo = itemView.findViewById(R.id.tvTitle);
            textDetalle = itemView.findViewById(R.id.tvDetalles);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            imagePelicula = itemView.findViewById(R.id.imagePelicula);
        }

        void setPelicula(Peliculas pelicula) {
            textTitulo.setText(pelicula.getNombre());
            textDetalle.setText(pelicula.getDetalles());
            ratingBar.setNumStars(5);
            ratingBar.setRating((float) pelicula.getRating());
            if (imagePelicula.getResources() != null){
                imagePelicula.setImageResource(pelicula.getImg());
                imagePelicula.setVisibility(View.VISIBLE);
            } else{
                imagePelicula.setVisibility(View.GONE);
            }

        }

        public void bind(final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(getAdapterPosition());
                }
            });
        }
    }
}


