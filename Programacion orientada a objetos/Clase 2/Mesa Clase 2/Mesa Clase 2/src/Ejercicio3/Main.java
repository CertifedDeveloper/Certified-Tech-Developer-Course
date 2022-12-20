package Ejercicio3;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 3
        System.out.println(cadenasDeTextoDistintas("Hola", "Mundo"));
    }
    static boolean cadenasDeTextoDistintas(String unTextoA, String unTextoB){
        return !unTextoA.equals(unTextoB);
    }
}
