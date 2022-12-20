import java.time.LocalDate;

public abstract class Embarcacion {
    private static final double PRECIO_BASE = 1000;
    private static final double VALOR_ADICIONAL = 500;
    private int anioFabricacion;
    private double eslora;
    private Capitan capitan;

    public Embarcacion(int anioFabricacion, double eslora, Capitan capitan) {
        this.anioFabricacion = anioFabricacion;
        this.eslora = eslora;
        this.capitan = capitan;
    }

    public double calcularAlquiler(){
        if (anioFabricacion > 2020){
            return PRECIO_BASE + VALOR_ADICIONAL;
        } else{
            return PRECIO_BASE;
        }
    }
}
