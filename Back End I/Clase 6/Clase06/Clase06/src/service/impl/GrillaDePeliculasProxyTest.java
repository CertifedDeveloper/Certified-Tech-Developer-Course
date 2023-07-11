package service.impl;

import excepciones.PeliculaNoHabilitadaException;
import model.IP;
import model.Pelicula;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.IGrillaDePeliculas;

import static org.junit.jupiter.api.Assertions.*;

class GrillaDePeliculasProxyTest {
    IP ip1;
    IP ip2;
    IP ip3;
    GrillaDePeliculas grilla;
    IGrillaDePeliculas grillaA;
    IGrillaDePeliculas grillaB;
    IGrillaDePeliculas grillaC;
    Pelicula peliculaA;
    Pelicula peliculaB;
    Pelicula peliculaC;
    @BeforeEach
    void doBefore(){
        ip1 = new IP(40,255,255,255);
        ip2 = new IP(51,255,255,255);
        ip3 = new IP(120,255,255,255);
        grilla = new GrillaDePeliculas();
        peliculaA = new Pelicula("peliculaA", "Argentina","www.peliculaA");
        peliculaB = new Pelicula("peliculaB", "Brasil","www.peliculaB");
        peliculaC = new Pelicula("peliculaC", "Colombia","www.peliculaC");
        grilla.agregarPelicula(peliculaA);
        grilla.agregarPelicula(peliculaB);
        grilla.agregarPelicula(peliculaC);
        grillaA = new GrillaDePeliculasProxy(ip1,grilla);
        grillaB = new GrillaDePeliculasProxy(ip2, grilla);
        grillaC = new GrillaDePeliculasProxy(ip3, grilla);
    }
    @Test
    void getPeliculaGrillaA() {
        try{
            assertEquals("www.peliculaA", grillaA.getPelicula("peliculaA").getLink());
        }
        catch (PeliculaNoHabilitadaException e){
            assertTrue(e.getMessage().contains("Película no disponible en su país"));
        }

        try{
            assertEquals("www.peliculaB", grillaA.getPelicula("peliculaB").getLink());
        }
        catch (PeliculaNoHabilitadaException e){
            assertTrue(e.getMessage().contains("Película no disponible en su país"));
        }

        try{
            assertEquals("www.peliculaC", grillaA.getPelicula("peliculaC").getLink());
        }
        catch (PeliculaNoHabilitadaException e){
            assertTrue(e.getMessage().contains("Película no disponible en su país"));
        }
    }

    @Test
    void getPeliculaGrillaB() {
        try{
            assertEquals("www.peliculaA", grillaB.getPelicula("peliculaA").getLink());
        }
        catch (PeliculaNoHabilitadaException e){
            assertTrue(e.getMessage().contains("Película no disponible en su país"));
        }

        try{
            assertEquals("www.peliculaB", grillaB.getPelicula("peliculaB").getLink());
        }
        catch (PeliculaNoHabilitadaException e){
            assertTrue(e.getMessage().contains("Película no disponible en su país"));
        }

        try{
            assertEquals("www.peliculaC", grillaB.getPelicula("peliculaC").getLink());
        }
        catch (PeliculaNoHabilitadaException e){
            assertTrue(e.getMessage().contains("Película no disponible en su país"));
        }
    }

    @Test
    void getPeliculaGrillaC() {
        try{
            assertEquals("www.peliculaA", grillaC.getPelicula("peliculaA").getLink());
        }
        catch (PeliculaNoHabilitadaException e){
            assertTrue(e.getMessage().contains("Película no disponible en su país"));
        }

        try{
            assertEquals("peliculaB", grillaC.getPelicula("peliculaB").getLink());
        }
        catch (PeliculaNoHabilitadaException e){
            assertTrue(e.getMessage().contains("Película no disponible en su país"));
        }

        try{
            assertEquals("www.peliculaC", grillaC.getPelicula("peliculaC").getLink());
        }
        catch (PeliculaNoHabilitadaException e){
            assertTrue(e.getMessage().contains("Película no disponible en su país"));
        }
    }
}