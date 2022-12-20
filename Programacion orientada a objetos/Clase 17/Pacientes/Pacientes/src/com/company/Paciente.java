package com.company;

import java.time.LocalDate;
public class Paciente {
    String nombre;
    String apellido;
    String historiaClinica;
    LocalDate fechaInternacion;
    LocalDate fechaAlta;


    Paciente(String nombre, String apellido, String historiaClinica, LocalDate fechaInternacion) throws FirstException
    {   LocalDate hoy= LocalDate.now();
        this.nombre=nombre;
        this.apellido=apellido;
        fechaAlta=null;
        if (fechaInternacion.isBefore(hoy)){
            this.fechaInternacion=fechaInternacion;
        } else {
            throw new FirstException("La fecha de internación debe ser anterior a la fecha actual");
        }
    }

    public LocalDate getFechaInternacion() {
        return fechaInternacion;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void darAlta(LocalDate fechaAlta) throws SecondException
    {
        if (fechaAlta.isAfter(fechaInternacion)){
            System.out.println("Ok");
        }
        else{
            throw new SecondException("La fecha de alta debe ser posterior a la fecha de internación");
        }
    }



}
