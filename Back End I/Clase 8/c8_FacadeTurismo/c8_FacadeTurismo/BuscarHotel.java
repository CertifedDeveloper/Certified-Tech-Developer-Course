package com.backend.c8_FacadeTurismo;

import java.time.LocalDate;
import java.util.ArrayList;

public class BuscarHotel {

    private ArrayList<Hotel> hoteles;

    public BuscarHotel(ArrayList<Hotel> hoteles) {
        this.hoteles = hoteles;
    }

    public Hotel buscarHotel(String ciudad, LocalDate fechaSalidaEntrada, LocalDate fechaRegresoSalida){

        Hotel hotel = null;
        for (Hotel h : this.hoteles) {
            if (h.getFechaEntrada().equals(fechaSalidaEntrada) && h.getFechaSalida().equals(fechaRegresoSalida) && h.getCiudad().equals(ciudad))
                hotel = h;

        }
        System.out.println(hotel);
        return hotel;

    }
}
