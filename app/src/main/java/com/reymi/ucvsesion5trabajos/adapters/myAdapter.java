package com.reymi.ucvsesion5trabajos.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.reymi.ucvsesion5trabajos.R;

import java.util.ArrayList;

public class myAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> peliculas;
    private int layout;

    public myAdapter(Context context, int layout, ArrayList<String> peliculas) {
        this.context = context;
        this.peliculas = peliculas;
        this.layout = layout;
    }

    @Override
    public int getCount() {
        return this.peliculas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.peliculas.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        if (view == null) {
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            view = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            holder.namePelicula = (TextView) view.findViewById(R.id.tvPelicula);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        String currentName = peliculas.get(position);

        holder.namePelicula.setText(currentName);

        return view;
    }

    static class ViewHolder {
        private TextView namePelicula;

    }
}
