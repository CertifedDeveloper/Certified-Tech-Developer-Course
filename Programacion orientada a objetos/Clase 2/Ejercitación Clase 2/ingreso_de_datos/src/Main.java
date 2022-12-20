import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        Scanner scanner;
        scanner = new Scanner(System.in);
        String nombre;
        String apellido;
        System.out.println("Ingrese su nombre: ");
        nombre = scanner.next();
        System.out.println("Ingrese su apellido: ");
        apellido = scanner.next();
        String inicialNombre = String.valueOf(nombre.charAt(0));
        String inicialApellido = String.valueOf(apellido.charAt(0));
        String iniciales = inicialNombre.concat(inicialApellido);
        System.out.println("Tus iniciales son: " + iniciales);
    }
}