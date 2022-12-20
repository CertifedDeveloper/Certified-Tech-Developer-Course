package com.camada15.clase22;

public abstract class Producto {
    private String nombre;
    private double precio;

    public Producto() {
    }

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public double calcularPrecio(){
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString(){
      return "-- " + nombre + " --" + "\n" +
              "Precio: $" + calcularPrecio();
    }
}
