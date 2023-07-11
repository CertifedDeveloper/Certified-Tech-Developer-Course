package com.company.tests;

import com.company.dao.AvionDAOH2;
import com.company.entidades.Avion;
import com.company.servicios.AvionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AvionDAOH2Test {
    Avion avionA;
    Avion avionB;
    AvionService avionService;
    @BeforeEach
    void doBefore(){
        avionA = new Avion();

        avionA.setId(1L);
        avionA.setMarca("marcaA");
        avionA.setModelo("modeloA");
        avionA.setMatricula("matriculaA");
        avionA.setFechaServicio(LocalDate.of(2000,1,1));

        avionB = new Avion();

        avionB.setId(2L);
        avionB.setMarca("marcaB");
        avionB.setModelo("modeloB");
        avionB.setMatricula("matriculaB");
        avionB.setFechaServicio(LocalDate.of(2000,1,1));

        avionService = new AvionService();
        avionService.setAvionIDAO(new AvionDAOH2());
    }

    @Test
    void registrar() {
        assertEquals(avionA, avionService.registrar(avionA));
        assertEquals(avionB, avionService.registrar(avionB));
        avionService.eliminar(1L);
        avionService.eliminar(2L);
    }

    @Test
    void eliminar() {
        avionService.registrar(avionA);
        avionService.eliminar(1L);
        assertEquals(null, avionService.buscar(1L));
    }

    @Test
    void buscar() {
        Avion avionAEncontrado = avionService.registrar(avionA);
        Avion avionBEncontrado = avionService.registrar(avionB);
        assertEquals(avionService.buscar(1L).toString(), avionAEncontrado.toString());
        assertEquals(avionService.buscar(2L).toString(), avionBEncontrado.toString());
        avionService.eliminar(1L);
        avionService.eliminar(2L);
    }

    @Test
    void buscarTodos() {
        avionService.registrar(avionA);
        avionService.registrar(avionB);
        assertNotEquals(null, avionService.buscarTodos());
        avionService.eliminar(1L);
        avionService.eliminar(2L);
    }
}