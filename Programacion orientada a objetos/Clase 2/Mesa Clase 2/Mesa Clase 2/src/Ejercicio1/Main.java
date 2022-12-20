package Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Ejercicio 1
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un número para saber si es primo: ");
        int numeroA = scanner.nextInt();
        esPrimo(numeroA);
    }
    static void esPrimo(int numero){
        int contador = 2;
        boolean primo = true;
        while ((primo) && (contador != numero)){
            if (esDivisible(numero, contador))
                primo = false;
            contador++;
        }
        if (primo){
            System.out.println("El número " + numero + " es primo");
            System.out.println();
        } else{
            System.out.println("El número " + numero + " no es primo");
            System.out.println();
        }
    }
    static boolean esDivisible(int n, int divisor){
        return n % divisor == 0;
    }
}