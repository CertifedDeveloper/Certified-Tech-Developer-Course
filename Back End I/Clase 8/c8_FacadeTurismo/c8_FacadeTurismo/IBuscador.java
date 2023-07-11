package com.backend.c8_FacadeTurismo;

import java.time.LocalDate;

public interface IBuscador {

    void buscarVueloYHotel(String ciudad, LocalDate fechaSalidaEntrada, LocalDate fechaRegresoSalida);
}
