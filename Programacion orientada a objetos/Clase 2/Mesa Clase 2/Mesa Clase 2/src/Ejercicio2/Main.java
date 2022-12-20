package Ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 2
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un primer número: ");
        int numeroA = scanner.nextInt();
        System.out.println("Ingrese un segundo número: ");
        int numeroB = scanner.nextInt();
        System.out.println("Ingrese un tercer número: ");
        int numeroC = scanner.nextInt();
        System.out.println("El mayor número es:");
        System.out.println(maximoEntreTresNumeros(numeroA, numeroB, numeroC));
    }
    static Integer maximoEntreTresNumeros(Integer unNumeroA, Integer unNumeroB, Integer
            unNumeroC){
        if (unNumeroA.compareTo(unNumeroB) > 0 && unNumeroA.compareTo(unNumeroC) > 0){
            return unNumeroA;
        } else if (unNumeroB.compareTo(unNumeroA) > 0 && unNumeroB.compareTo(unNumeroC) > 0){
            return unNumeroB;
        } else{
            return unNumeroC;
        }
    }
}
