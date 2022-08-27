package com.reymi.ucvsesion5trabajos.modelo;

import android.os.Parcel;
import android.os.Parcelable;

public class Peliculas implements Parcelable {

    private String nombre;
    private String detalles;
    private double rating;
    private String descripcion;
    private int img;


    public Peliculas(String nombre, String detalles, double rating, String descripcion, int img) {
        this.nombre = nombre;
        this.detalles = detalles;
        this.rating = rating;
        this.descripcion = descripcion;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    //metodos de la clase parcelable

    protected Peliculas(Parcel in) {
        nombre = in.readString();
        detalles = in.readString();
        rating = in.readDouble();
        descripcion = in.readString();
        img = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(detalles);
        dest.writeDouble(rating);
        dest.writeString(descripcion);
        dest.writeInt(img);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Peliculas> CREATOR = new Parcelable.Creator<Peliculas>() {
        @Override
        public Peliculas createFromParcel(Parcel in) {
            return new Peliculas(in);
        }

        @Override
        public Peliculas[] newArray(int size) {
            return new Peliculas[size];
        }
    };
}
