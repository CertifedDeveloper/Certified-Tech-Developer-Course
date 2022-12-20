public class Finalizado implements EstadoReparacion{
    private Reparacion r;

    public Finalizado(Reparacion r) {
        this.r = r;
    }
    public void cambiarDireccion(String direccion) throws RuntimeException{
        throw new RuntimeException("El artículo está Finalizado. No se puede cambiar dirección.");
    };
    public void valorPresupuesto(double valor) throws RuntimeException{
        throw new RuntimeException("El artículo está Finalizado. No se puede asignar presupuesto inicial.");
    };
    public void sumarRepuesto(double valor) throws RuntimeException{
        throw new RuntimeException("El artículo está Finalizado. No se puede sumar repuesto.");
    };
    public void pasarSigPaso() throws RuntimeException{
        throw new RuntimeException("El artículo está en estado Finalizado.  No se puede pasar a otro paso.");
    };
}
