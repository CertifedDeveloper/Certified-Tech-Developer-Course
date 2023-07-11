import java.util.HashMap;

public class RopaFactory {
    public static final HashMap<String, Ropa> cache = new HashMap<>();
    private static int contador;
    public static Ropa generarPrenda(String tipo){
        if (!cache.containsKey(tipo)){
            Ropa ropa = new Ropa(tipo);
            cache.put(tipo, ropa);
            System.out.println("Guardando en cache");
        }
        Ropa ropa = new Ropa(tipo);
        contador++;
        System.out.println("Creando prenda");
        System.out.println(ropa);
        return ropa;
    }

    public static int getContador() {
        return contador;
    }
}
