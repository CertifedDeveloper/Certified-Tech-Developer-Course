public class Contenedor implements Comparable<Contenedor>{
    private int identificador;
    private String paisProcedencia;
    private boolean materialPeligroso;

    public Contenedor(int identificador, String paisProcedencia, boolean materialPeligroso) {
        this.identificador = identificador;
        this.paisProcedencia = paisProcedencia;
        this.materialPeligroso = materialPeligroso;
    }

    public boolean isMaterialPeligroso() {
        return materialPeligroso;
    }

    public String getPaisProcedencia() {
        return paisProcedencia;
    }

    @Override
    public int compareTo(Contenedor o) {
        return Integer.compare(identificador,o.identificador);
    }

    @Override
    public String toString() {
        return "Identificador: " + identificador + "\n" +
                "Pais de procedencia: " + paisProcedencia + "\n" +
                "Contiene Material Peligroso: " + (materialPeligroso ? "Sí" : "No") + "\n" +
                "---------------------------------------------------";
    }
}
