package service;

import excepciones.PeliculaNoHabilitadaException;
import model.Pelicula;

public interface IGrillaDePeliculas {
    Pelicula getPelicula(String nombre) throws PeliculaNoHabilitadaException;
}
