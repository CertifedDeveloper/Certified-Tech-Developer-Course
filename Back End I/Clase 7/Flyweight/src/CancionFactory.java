import java.util.ArrayList;
import java.util.HashMap;

public class CancionFactory {
    private static final HashMap<ListaReproduccion, ArrayList<Cancion>> cache = new HashMap<>();
    public void obtenerCancion(ListaReproduccion listaReproduccion, Cancion cancion){
        ArrayList<Cancion> listaCancion = cache.get(listaReproduccion);
        if (listaCancion == null){
            listaCancion = new ArrayList<>();
            cancion.getLista().add(listaReproduccion);
            listaCancion.add(cancion);
            cache.put(listaReproduccion, listaCancion);
            System.out.println("Creo una canción en la lista de reproduccion "+ listaReproduccion.getNombre());
        } else{
            for (Cancion elemento : listaCancion){
                if (!elemento.getNombre().equals(cancion.getNombre())){
                    listaCancion.add(cancion);
                    cache.remove(listaReproduccion);
                    cache.put(listaReproduccion, listaCancion);
                }
            }
        }
    }

    public HashMap<ListaReproduccion, ArrayList<Cancion>> getCache() {
        return cache;
    }
}
