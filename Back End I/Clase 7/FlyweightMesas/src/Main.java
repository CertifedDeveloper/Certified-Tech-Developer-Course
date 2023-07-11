public class Main {
    public static void main(String[] args) {
        ArbolFactory arbolFactory = new ArbolFactory();
        Arbol a1 = arbolFactory.plantarArbol("frutales");
        Arbol a2 = arbolFactory.plantarArbol("ornamental");
        Arbol a3;
        Arbol a4;
        for (int i = 0; i < 100; i++){
            a3 = arbolFactory.plantarArbol("frutales");
            System.out.println(a3.getContador());
        }
        for (int i = 0; i < 100; i++){
            a4 = arbolFactory.plantarArbol("ornamental");
            System.out.println(a4.getContador());
        }
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory()-runtime.freeMemory()) / (1024 * 1024));
    }
}