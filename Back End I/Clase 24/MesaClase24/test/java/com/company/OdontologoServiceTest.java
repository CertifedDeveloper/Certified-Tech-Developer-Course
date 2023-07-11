package com.company;

import com.company.DAO.Impl.OdontologoDAOH2;
import com.company.Model.Odontologo;
import com.company.Service.OdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    Odontologo odontologo1;
    Odontologo odontologo2;
    Odontologo odontologo3;
    Odontologo odontologo4;
    OdontologoService odontologoService;
    ArrayList<Odontologo> odontologos = new ArrayList<>();
    @BeforeEach
    void doBefore(){
        odontologo1 = new Odontologo("AAA","Mike","Power");
        odontologo2 = new Odontologo("BBB","Jack","Sparrow");
        odontologo3 = new Odontologo("CCC","Peter","Parker");
        odontologo4 = new Odontologo("DDD","MikeB","PowerB");
        odontologoService = new OdontologoService(new OdontologoDAOH2());
    }

    @Test
    void guardar() {
        Odontologo odontologoA = new Odontologo("AAA","Mike","Power");
        odontologoA.setId(1);
        assertEquals(odontologoA.toString(), odontologoService.guardar(odontologo1).toString());
    }

    @Test
    void buscarTodos() {
        Odontologo odontologoA = new Odontologo("AAA","Mike","Power");
        Odontologo odontologoB = new Odontologo("BBB","Jack","Sparrow");
        Odontologo odontologoC = new Odontologo("CCC","Peter","Parker");
        Odontologo odontologoD = new Odontologo("DDD","MikeB","PowerB");
        odontologoA.setId(1);
        odontologoB.setId(2);
        odontologoC.setId(3);
        odontologoD.setId(4);
        odontologos.add(odontologoA);
        odontologos.add(odontologoB);
        odontologos.add(odontologoC);
        odontologos.add(odontologoD);

        odontologoService.guardar(odontologo2);
        odontologoService.guardar(odontologo3);
        odontologoService.guardar(odontologo4);
        assertEquals(odontologos.toString(), odontologoService.buscarTodos().toString());
    }
}