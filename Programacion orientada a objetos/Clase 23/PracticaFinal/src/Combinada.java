import java.util.ArrayList;
import java.util.List;

public class Combinada extends UnidadTrabajo{
    private double coeficienteGlobal;
    private double montoMaterial;
    private List<UnidadTrabajo> unidades = new ArrayList<>();

    public List<UnidadTrabajo> getUnidades() {
        return unidades;
    }

    public void setCoeficienteGlobal(double coeficienteGlobal) {
        this.coeficienteGlobal = coeficienteGlobal;
    }

    @Override
    public double calcularMonto() {
        int suma = 0;
        for (UnidadTrabajo unidadTrabajo: unidades){
            suma += unidadTrabajo.calcularMonto();
        }
        return suma * coeficienteGlobal;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Coeficiente global: " + coeficienteGlobal;
    }
}
