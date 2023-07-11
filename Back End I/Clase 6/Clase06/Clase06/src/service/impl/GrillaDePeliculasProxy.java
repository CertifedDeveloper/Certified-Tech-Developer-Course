package service.impl;

import excepciones.PeliculaNoHabilitadaException;
import model.IP;
import model.Pelicula;
import service.IGrillaDePeliculas;

public class GrillaDePeliculasProxy implements IGrillaDePeliculas {
    private IP ip;
    private GrillaDePeliculas grillaDePeliculas;

    public GrillaDePeliculasProxy(IP ip, GrillaDePeliculas grillaDePeliculas) {
        this.ip = ip;
        this.grillaDePeliculas = grillaDePeliculas;
    }

    public GrillaDePeliculas getGrillaDePeliculas() {
        return grillaDePeliculas;
    }

    public void setGrillaDePeliculas(GrillaDePeliculas grillaDePeliculas) {
        this.grillaDePeliculas = grillaDePeliculas;
    }

    public IP getIp() {
        return ip;
    }

    public void setIp(IP ip) {
        this.ip = ip;
    }

    private boolean verificaPais(Pelicula pelicula) {
        boolean paisVerificado = false;
        if (ip.getN1() < 50 && "argentina".equalsIgnoreCase(pelicula.getPais())) {
            return true;
        }
        else if (ip.getN1() < 100 && ip.getN1() >= 50 && "brasil".equalsIgnoreCase(pelicula.getPais())) {
            return true;
        } else if (ip.getN1() < 150 && ip.getN1() >= 100 && "colombia".equalsIgnoreCase(pelicula.getPais())) {
            return true;
        }
        return paisVerificado;
    }

    @Override
    public Pelicula getPelicula(String nombre) throws PeliculaNoHabilitadaException {
        Pelicula peliculaEncontrada = null;
        for (Pelicula pelicula : grillaDePeliculas.getPeliculas()) {
            if (pelicula.getNombre().equalsIgnoreCase(nombre)) {
                peliculaEncontrada = pelicula;
            }
        }
        if (!verificaPais(peliculaEncontrada)) {
            throw new PeliculaNoHabilitadaException("Película no disponible en su país");
        }
        return grillaDePeliculas.getPelicula(nombre);
    }
}