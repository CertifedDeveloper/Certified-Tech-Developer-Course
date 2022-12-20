import java.util.ArrayList;
import java.util.List;

public class Programa extends OfertaAcademica{
    private double bonus;
    private List<OfertaAcademica> cursos;

    public Programa(String nombre, String descripcion, double bonus) {
        super(nombre, descripcion);
        this.bonus = bonus;
        cursos = new ArrayList<>();
    }

    public List<OfertaAcademica> getCursos() {
        return cursos;
    }

    @Override
    public double calcularPrecio() {
        double suma = 0;
        double bono = (100 - bonus) / 100;
        for (OfertaAcademica ofertaAcademica: cursos){
            suma += ofertaAcademica.calcularPrecio();
        }
        setPrecio(suma * bono);
        return suma * bono;
    }
}
