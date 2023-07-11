public abstract class AnalistaDeCalidad {
    private AnalistaDeCalidad siguienteAnalista;

    public abstract String validarCalidadDelProducto(Articulo articulo);

    public void setSiguienteAnalista(AnalistaDeCalidad siguienteAnalista) {
        this.siguienteAnalista = siguienteAnalista;
    }

    public AnalistaDeCalidad getSiguienteAnalista() {
        return siguienteAnalista;
    }
}
