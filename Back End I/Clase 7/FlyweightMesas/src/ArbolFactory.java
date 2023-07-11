import java.util.HashMap;

public class ArbolFactory {
    private HashMap<String, Arbol> cache = new HashMap<>();

    public Arbol plantarArbol(String tipo) {
        int contador = 0;
        Arbol arbol = new Arbol(tipo);
        if (!cache.containsKey(tipo)) {
            if (tipo.equalsIgnoreCase("ornamental")) {
                System.out.println("Creando un árbol ornamental\n");
                arbol.setAlto(200);
                arbol.setAncho(400);
                arbol.setColor("verde");
            }
            if (tipo.equalsIgnoreCase("frutales")) {
                System.out.println("Creando un árbol frutal\n");
                arbol.setAlto(500);
                arbol.setAncho(300);
                arbol.setColor("rojo");
            }
            if (tipo.equalsIgnoreCase("florales")) {
                System.out.println("Creando un árbol floral\n");
                arbol.setAlto(100);
                arbol.setAncho(200);
                arbol.setColor("celeste");
            }
            cache.put(tipo, arbol);
        }
        arbol.incrementar();
        return arbol;
    }
}

