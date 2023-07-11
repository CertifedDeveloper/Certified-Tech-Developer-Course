public class Lote extends AnalistaDeCalidad{
    @Override
    public String validarCalidadDelProducto(Articulo articulo) {
        setSiguienteAnalista(new Peso());
        if (articulo.getLote() >= 1000 && articulo.getLote() <= 2000){
            return getSiguienteAnalista().validarCalidadDelProducto(articulo);
        }
        return "rechazado";
    }
}
