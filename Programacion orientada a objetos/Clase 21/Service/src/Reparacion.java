public class Reparacion {
    private String articulo;
    private double costo;
    private String direccionEntrega;
    private EstadoReparacion estado;

    public Reparacion(String articulo) {
        this.articulo = articulo;
        setEstado(new EnPresupuesto(this));
    }

    public void setEstado(EstadoReparacion estado) {
        this.estado = estado;
    }

    public EstadoReparacion getEstado() {
        return estado;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public double getCosto() {
        return costo;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public void cambiarDireccion(String direccion){
        getEstado().cambiarDireccion(direccion);
    }
    public void valorPresupuesto(double valor){
        getEstado().valorPresupuesto(valor);
    }
    public void sumarRepuesto(double valor){
        getEstado().sumarRepuesto(valor);
    }
    public void pasarSigPaso(){
        getEstado().pasarSigPaso();
    }

    @Override
    public String toString() {
        return "Reparacion{" +
                "articulo='" + articulo + '\'' +
                ", costo=" + costo +
                ", direccionEntrega='" + direccionEntrega + '\'' +
                ", estado=" + estado.getClass().getName() +
                '}';
    }
}
