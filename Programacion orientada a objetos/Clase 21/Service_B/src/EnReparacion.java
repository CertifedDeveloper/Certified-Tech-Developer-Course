public class EnReparacion implements EstadoReparacion{
    private Reparacion r;

    public EnReparacion(Reparacion r) {
        this.r = r;
    }
    public void cambiarDireccion(String direccion) throws RuntimeException{
        throw new RuntimeException("El artículo está en Reparación. No se puede cambiar la dirección.");
    };
    public void valorPresupuesto(double valor) throws RuntimeException{
        throw new RuntimeException("El artículo está en Reparación. No se puede asignar presupuesto inicial.");
    };
    public void sumarRepuesto(double valor) throws RuntimeException{
        r.setCosto(r.getCosto() + valor);
    };
    public void pasarSigPaso(){
        EstadoReparacion estado = ReparacionFactory.getInstance().crearReparacion("ParaEnvio", r);
        r.setEstado(estado);
        System.out.println(r);
    };
}
