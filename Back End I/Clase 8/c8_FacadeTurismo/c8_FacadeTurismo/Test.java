package com.backend.c8_FacadeTurismo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        Vuelo vuelo1 = new Vuelo(LocalDate.of(2023,01,01),LocalDate.of(2023,01,30),"Buenos aires", "Bariloche");
        Vuelo vuelo2 = new Vuelo(LocalDate.of(2023,02,01),LocalDate.of(2023,02,28),"Buenos aires", "Bariloche");

        Hotel h1 = new Hotel(LocalDate.of(2023,01,01),LocalDate.of(2023,01,30),"Buenos aires");
        Hotel h2 = new Hotel(LocalDate.of(2023,02,01),LocalDate.of(2023,02,28),"Bariloche");

        ArrayList<Vuelo> vuelosDisponibles = new ArrayList<>();
        vuelosDisponibles.add(vuelo1);
        vuelosDisponibles.add(vuelo2);

        ArrayList<Hotel> hotelesDisponibles = new ArrayList<>();
        hotelesDisponibles.add(h1);
        hotelesDisponibles.add(h2);

        BuscadorImpl buscadorImpl = new BuscadorImpl(vuelosDisponibles,hotelesDisponibles);

        buscadorImpl.buscarVueloYHotel("Bariloche",LocalDate.of(2023,02,01),LocalDate.of(2023,02,28));

    }
}
