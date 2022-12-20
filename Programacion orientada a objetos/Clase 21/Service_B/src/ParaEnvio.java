public class ParaEnvio implements EstadoReparacion{
    private Reparacion r;

    public ParaEnvio(Reparacion r) {
        this.r = r;
    }
    public void cambiarDireccion(String direccion){
        r.setDireccionEntrega(direccion);
    };
    public void valorPresupuesto(double valor) throws RuntimeException{
        throw new RuntimeException("El artículo está en Envío. No se puede asignar presupuesto inicial.");
    };
    public void sumarRepuesto(double valor) throws RuntimeException{
        throw new RuntimeException("El artículo está en Envío. No se puede sumar repuesto.");
    };
    public void pasarSigPaso(){
        EstadoReparacion estado = ReparacionFactory.getInstance().crearReparacion("Finalizado", r);
        r.setEstado(estado);
        System.out.println(r);
    };
}
