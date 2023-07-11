package com.example.clinicaOdontologica.dominio;

import com.example.clinicaOdontologica.servicios.PacienteService;

import java.time.LocalDate;

public class Paciente {
    private int id;
    private String nombre;
    private String apellido;
    private String email;
    private String DNI;
    private LocalDate fechaIngreso;
    private Direccion domicilio;
    private Odontologo odontologo;

    public Paciente(int id, String nombre, String apellido, String email, String DNI, LocalDate fechaIngreso, Direccion domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.DNI = DNI;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
    }

    public Paciente(int id, String nombre, String apellido, String email, String DNI, LocalDate fechaIngreso, Direccion domicilio, Odontologo odontologo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.DNI = DNI;
        this.fechaIngreso = fechaIngreso;
        this.domicilio = domicilio;
        this.odontologo = odontologo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }
}
