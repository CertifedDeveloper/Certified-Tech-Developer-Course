package com.backend.c8_FacadeTurismo;

import java.time.LocalDate;
import java.util.ArrayList;

public class BuscarVuelo {

    private ArrayList<Vuelo> vuelos;

    public BuscarVuelo(ArrayList<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }

    public Vuelo buscarVuelo(String ciudad, LocalDate fechaSalidaEntrada, LocalDate fechaRegresoSalida){

        Vuelo vuelo = null;
        for (Vuelo v : this.vuelos) {
            if (v.getFechaSalida().equals(fechaSalidaEntrada) && v.getFechaRegreso().equals(fechaRegresoSalida) && v.getDestino().equals(ciudad))
                vuelo = v;

        }
        System.out.println(vuelo);
        return vuelo;

    }
}
