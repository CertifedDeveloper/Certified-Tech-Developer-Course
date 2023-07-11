public class Main {
    public static void main(String[] args) {
        ListaReproduccion listaA = new ListaReproduccion("listaA");
        ListaReproduccion listaB = new ListaReproduccion("listaB");
        ListaReproduccion listaC = new ListaReproduccion("listaC");
        CancionFactory cancionFactory = new CancionFactory();

        Cancion cancionA = new Cancion();
        cancionA.setNombre("cancionA");
        cancionFactory.obtenerCancion(listaA, cancionA);

        Cancion cancionB = new Cancion();
        cancionB.setNombre("cancionB");
        cancionFactory.obtenerCancion(listaB, cancionB);

        Cancion cancionC = new Cancion();
        cancionC.setNombre("cancionC");
        cancionFactory.obtenerCancion(listaA, cancionC);

        System.out.println(cancionA);
        System.out.println(cancionB);
        System.out.println(cancionC);
    }
}