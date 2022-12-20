public class Main {
    public static void main(String[] args) {
        Perro perroA = new Perro("Nombre", "raza", 1900, true);
        Perro perroB = new Perro("Nombre", "raza", 6., false);
        System.out.println(perroA.mostrarEdad());
        System.out.println(perroA.poderPerderse());
        perroB.poderAdoptarse();
        System.out.println(perroB.isEnAdopcion());
    }
}