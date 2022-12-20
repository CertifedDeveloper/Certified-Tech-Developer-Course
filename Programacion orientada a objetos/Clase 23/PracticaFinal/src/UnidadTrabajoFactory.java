public class UnidadTrabajoFactory {
    private static UnidadTrabajoFactory instancia;

    private UnidadTrabajoFactory() {
    }
    public static UnidadTrabajoFactory getInstancia(){
        if (instancia == null){
            instancia = new UnidadTrabajoFactory();
        }
        return instancia;
    }
    public UnidadTrabajo crearUnidadTrabajo(String tipo) throws RuntimeException{
        switch (tipo){
            case "Simple":
                return new Simple();
            case "Combinada":
                return new Combinada();
            default:
                throw new RuntimeException("La unidad de trabajo no existe");
        }
    }
}
