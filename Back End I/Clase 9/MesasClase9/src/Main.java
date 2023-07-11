public class Main {
    public static void main(String[] args) {
        Ropa pantalonA = RopaFactory.generarPrenda("pantalon");
        Ropa pantalonB = RopaFactory.generarPrenda("pantalon");
        Ropa pantalonC = RopaFactory.generarPrenda("pantalon");
        Ropa pantalonD = RopaFactory.generarPrenda("pantalon");
        Ropa pantalonE = RopaFactory.generarPrenda("pantalon");
        Ropa remeraA = RopaFactory.generarPrenda("remera");
        Ropa remeraB = RopaFactory.generarPrenda("remera");

        System.out.println("El tamaño en cache es: ");
        System.out.println(RopaFactory.cache.values().size());
        System.out.println("-------------------------------------------------");
        System.out.println("La cantidad de prendas creadas son: ");
        System.out.println(RopaFactory.getContador());
    }
}