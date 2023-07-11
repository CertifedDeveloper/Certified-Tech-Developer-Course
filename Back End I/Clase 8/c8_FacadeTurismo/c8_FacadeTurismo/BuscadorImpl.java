package com.backend.c8_FacadeTurismo;

import java.time.LocalDate;
import java.util.ArrayList;

public class BuscadorImpl implements IBuscador{

    private BuscarVuelo buscadorVuelo;
    private BuscarHotel buscadorHotel;

    public BuscadorImpl(ArrayList arrayVuelo, ArrayList arrayHotel) {
        this.buscadorVuelo = new BuscarVuelo(arrayVuelo);
        this.buscadorHotel = new BuscarHotel(arrayHotel);
    }

    @Override
    public void buscarVueloYHotel(String ciudad, LocalDate fechaSalidaEntrada, LocalDate fechaRegresoSalida) {

        if((buscadorVuelo.buscarVuelo(ciudad,fechaSalidaEntrada,fechaRegresoSalida)) != null){
            System.out.println("Vuelo encontrado");
        } else {
            System.out.println("No se encontro un vuelvo.");
        }

        if((buscadorHotel.buscarHotel(ciudad,fechaSalidaEntrada,fechaRegresoSalida)) != null){
            System.out.println("Hotel encontrado");
        } else {
            System.out.println("No se encontro un hotel.");
        }

    }
}
