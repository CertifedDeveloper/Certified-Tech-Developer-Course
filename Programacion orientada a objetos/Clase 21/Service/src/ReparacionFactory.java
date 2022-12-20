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
    public Reparacion crearReparacion(String articulo){
        Reparacion reparacion = new Reparacion(articulo);
        reparacion.setCosto(0);
        reparacion.setDireccionEntrega("Sin dirección");
        System.out.println(reparacion);
        return reparacion;
    }
}
