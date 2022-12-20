public class ReparacionFactory {
    private static ReparacionFactory instancia;
    private ReparacionFactory(){
    };
    public static ReparacionFactory getInstance(){
        if (instancia == null){
            instancia = new ReparacionFactory();
        }
        return instancia;
    }
    public EstadoReparacion crearReparacion(String tipo, Reparacion reparacion) throws RuntimeException{
        switch (tipo){
            case ("EnPresupuesto"):
                return new EnPresupuesto(reparacion);
            case ("EnReparacion"):
                return new EnReparacion(reparacion);
            case("ParaEnvio"):
                return new ParaEnvio(reparacion);
            case("Finalizado"):
                return new Finalizado(reparacion);
            default:
                throw new RuntimeException("El estado no se encuentra.");
        }
    }
}
