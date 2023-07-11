public class Envase extends AnalistaDeCalidad{
    @Override
    public String validarCalidadDelProducto(Articulo articulo) {
        if (articulo.getEnvasado().equals("sano") || articulo.getEnvasado().equals("casi sano")){
            return "aceptado";
        }
        return "rechazado";
    }
}
