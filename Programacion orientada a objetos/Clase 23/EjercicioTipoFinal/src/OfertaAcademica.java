public abstract class OfertaAcademica {
    private String nombre;
    private String descripcion;
    private double precio;

    public OfertaAcademica(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        precio = 0;
    }
    public abstract double calcularPrecio();

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "-------- Informe --------" + "\n" +
                "El nombre del " + getClass().getName().toLowerCase() + " es: " + nombre + "\n" +
                "Su precio es: " + calcularPrecio() + "\n" +
                "-------------------------------------------------";
    }
}
