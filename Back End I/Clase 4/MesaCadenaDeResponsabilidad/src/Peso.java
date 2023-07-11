public class Peso extends AnalistaDeCalidad{
    @Override
    public String validarCalidadDelProducto(Articulo articulo) {
        setSiguienteAnalista(new Envase());
        if (articulo.getPeso() >= 1200 && articulo.getPeso() <= 1300){
            return getSiguienteAnalista().validarCalidadDelProducto(articulo);
        }
        return "rechazado";
    }
}
