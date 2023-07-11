public class Ropa {
    private String talle;
    private String tipo;
    private boolean esNuevo;
    private boolean importada;

    public Ropa(String tipo) {
        this.tipo = tipo;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public boolean isEsNuevo() {
        return esNuevo;
    }

    public void setEsNuevo(boolean esNuevo) {
        this.esNuevo = esNuevo;
    }

    public boolean isImportada() {
        return importada;
    }

    public void setImportada(boolean importada) {
        this.importada = importada;
    }

    @Override
    public String toString() {
        return "Ropa{" +
                "talle='" + talle + '\'' +
                ", tipo='" + tipo + '\'' +
                ", esNuevo=" + esNuevo +
                ", importada=" + importada +
                '}' + "\n" +"-------------------------------------------------------------------";
    }
}
