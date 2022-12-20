import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<UnidadTrabajo> unidades;

    public Empresa(String nombre) {
        this.nombre = nombre;
        unidades = new ArrayList<>();
    }

    public List<UnidadTrabajo> getUnidades() {
        return unidades;
    }

    public void mostrarInforme(){
        System.out.println("-----------------------------Informe---------------------------------");
        for(UnidadTrabajo unidadTrabajo: unidades){
            System.out.println(unidadTrabajo);
            System.out.println("------------------------------------------------------------------");
        }
    }
}
