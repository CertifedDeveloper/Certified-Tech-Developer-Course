public class EnPresupuesto implements EstadoReparacion{
    private Reparacion r;

    public EnPresupuesto(Reparacion r) {
        this.r = r;
    }
    public void cambiarDireccion(String direccion) throws RuntimeException{
        throw new RuntimeException("El artículo está en Presupuesto. No se puede cambiar la dirección.");
    };
    public void valorPresupuesto(double valor){
        r.setCosto(valor);
    };
    public void sumarRepuesto(double valor) throws RuntimeException{
        throw new RuntimeException("El artículo está en Presupuesto. No se puede sumar repuesto.");
    };
    public void pasarSigPaso(){
        r.setEstado(new EnReparacion(r));
        System.out.println(r);
    };
}
