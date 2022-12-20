import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese nombre del perro: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese cantidad de comida: ");
        Double comida = scanner.nextDouble();
        if (comida >= 3) {
            Integer paquetes = cuantosPaquetes(comida);
            System.out.println(nombre + " precisa " + paquetes + " paquetes");
        } else{
            System.out.println("Debe ingresar una cantidad de comida mayor a 3 Kg");
        }
    }
    public static Integer cuantosPaquetes(Double comida){
        Integer contador = 0;
        Double suma = 0.0;
        Scanner scanner = new Scanner(System.in);
        while(suma <= comida){
            System.out.println("Ingrese cantidad de comida del paquete: ");
            suma += scanner.nextDouble();
            contador++;
        }
        return contador;
    }
}