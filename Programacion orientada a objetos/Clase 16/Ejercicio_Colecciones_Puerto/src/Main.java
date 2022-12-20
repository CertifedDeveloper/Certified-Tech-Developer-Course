public class Main {
    public static void main(String[] args) {
        Contenedor contenedorA = new Contenedor(3,"Desconocida", true);
        Contenedor contenedorB = new Contenedor(1, "EEUU", false);
        Contenedor contenedorC = new Contenedor(2, "Desconocida", false);
        Puerto puerto = new Puerto();
        puerto.ingresarContenedor(contenedorA);
        puerto.ingresarContenedor(contenedorB);
        puerto.ingresarContenedor(contenedorC);
        puerto.mostrarContenedores();
        System.out.println("La cantidad de contenedores peligrosos cuya procedencia es desconocida es: " + puerto.mostrarContenedoresPeligrosos());
    }
}