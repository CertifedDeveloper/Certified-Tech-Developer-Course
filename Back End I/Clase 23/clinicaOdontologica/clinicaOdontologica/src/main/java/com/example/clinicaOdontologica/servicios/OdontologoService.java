package com.example.clinicaOdontologica.servicios;

import com.example.clinicaOdontologica.dominio.Odontologo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OdontologoService {
    Odontologo odontologoA = new Odontologo(1,"nombreA","nombreB", "1234");
    Odontologo odontologoB = new Odontologo(1,"nombreB","nombreB", "2345");
    ArrayList<Odontologo> odontologos = new ArrayList<>();
    public List<Odontologo> buscarTodos(){
        return Arrays.asList(odontologoA,odontologoB);
    }
    public Odontologo odontologoPorId(int id){
        odontologos.add(odontologoA);
        odontologos.add(odontologoB);
        Odontologo odontologoEncontrado = null;
        for (Odontologo odontologo: odontologos){
            if (odontologo.getId() == id){
                odontologoEncontrado = odontologo;
            }
        }
        return odontologoEncontrado;
    }
}
