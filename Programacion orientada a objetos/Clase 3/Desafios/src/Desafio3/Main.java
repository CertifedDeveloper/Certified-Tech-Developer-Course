package Desafio3;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Ingrese un numero entero n: ");
        int n = scanner.nextInt();
        Integer numero = 2;
        int cuenta = 0;
        Stack<String> arr = new Stack();
        while(cuenta < n){
            boolean esPrimo = true;
            int contador = 2;
            while (esPrimo && contador != numero){
                if (numero % contador == 0){
                    esPrimo = false;
                }
                contador++;
            }
            if (esPrimo){
                arr.push(numero.toString());
                cuenta++;
            }
            numero++;
        }
        String numerosPrimos = String.join(",", arr);
        System.out.println("Los primeros " + n + " números primos son: " + numerosPrimos);
    }
}
