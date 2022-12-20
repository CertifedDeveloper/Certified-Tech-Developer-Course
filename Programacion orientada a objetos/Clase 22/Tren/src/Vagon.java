import java.util.ArrayList;
import java.util.List;

public class Vagon implements Componente{
    private List<Componente> componentes;

    public Vagon() {
        componentes = new ArrayList<>();
    }
    public void agregarComponente(Componente c) throws Exception{
        if (!c.getClass().getName().equals("Vagon") || !c.getClass().getName().equals("Locomotora")){
            componentes.add(c);
        } else{
            throw new Exception("No se pueden agregar elementos del tipo vagón o locomotora.");
        }
    }
    public void removerComponente(Componente c){
        componentes.remove(c);
    }
    @Override
    public double calcularArea() {
        double suma = 0;
        for (Componente componente: componentes){
            suma += componente.calcularArea();
        }
        return suma;
    }
}
