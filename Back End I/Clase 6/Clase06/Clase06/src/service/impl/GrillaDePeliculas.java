package service.impl;

import model.Pelicula;
import service.IGrillaDePeliculas;

import java.util.ArrayList;

public class GrillaDePeliculas implements IGrillaDePeliculas {
    private ArrayList<Pelicula> peliculas;

    public GrillaDePeliculas() {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public Pelicula getPelicula(String nombre) {
        Pelicula peliculaEncontrada = null;
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getNombre().equalsIgnoreCase(nombre)) {
                peliculaEncontrada = pelicula;
            }
        }
        System.out.println(peliculaEncontrada.getLink());
        return peliculaEncontrada;
    }
    public void agregarPelicula(Pelicula pelicula){
        peliculas.add(pelicula);
    }

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }
}

