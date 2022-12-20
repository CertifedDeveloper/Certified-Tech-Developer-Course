import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;import java.util.List;

public class Puerto {
    private List<Contenedor> contenedores;

    public Puerto() {
        contenedores = new ArrayList<>();
    }
    public void ingresarContenedor(Contenedor contenedor){
        contenedores.add(contenedor);
    }
    public void mostrarContenedores(){
        Collections.sort(contenedores);
        for (Contenedor contenedor: contenedores){
            System.out.println(contenedor);
        }
    }
    public int mostrarContenedoresPeligrosos(){
        int cantidad = 0;
        for (Contenedor contenedor: contenedores){
            if (contenedor.isMaterialPeligroso() && contenedor.getPaisProcedencia().equals("Desconocida")){
                cantidad++;
            }
        }
        return cantidad;
    }
}
