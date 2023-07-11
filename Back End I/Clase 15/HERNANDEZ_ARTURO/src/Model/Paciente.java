package Model;

import java.time.LocalDate;

public class Paciente {

    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private LocalDate fecha_ingreso;
    private Direccion domicilio;

    public Paciente(String nombre, String apellido, String dni, LocalDate fecha_ingreso, Direccion domicilio) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_ingreso = fecha_ingreso;
        this.domicilio = domicilio;
    }

    public Paciente(int id, String nombre, String apellido, String dni, LocalDate fecha_ingreso, Direccion domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.fecha_ingreso = fecha_ingreso;
        this.domicilio = domicilio;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public LocalDate getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(LocalDate fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Direccion getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Direccion domicilio) {
        this.domicilio = domicilio;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", fecha_ingreso=" + fecha_ingreso +
                ", domicilio=" + domicilio +
                '}';
    }
}
