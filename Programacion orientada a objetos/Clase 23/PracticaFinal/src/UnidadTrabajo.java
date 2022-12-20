public abstract class UnidadTrabajo {
    private String nombre;
    private String descripcion;
    public abstract double calcularMonto();

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "--------------UnidadTrabajo--------------" + "\n" +
                "Nombre: " + nombre + "\n" +
                "Descripcion: " + descripcion + "\n" +
                "Monto: " + calcularMonto();
    }
}
