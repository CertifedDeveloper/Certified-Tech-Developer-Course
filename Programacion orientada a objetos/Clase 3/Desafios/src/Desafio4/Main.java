package Desafio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        System.out.println("Ingrese el número de horas semanales: ");
        int x = scanner.nextInt();
        double sueldoSemanal;
        if (x <= 40){
            sueldoSemanal = x * 875;
        } else{
            sueldoSemanal = 40 * 875 + (x - 40) * 875 * 1.5;
        }
        System.out.println("El sueldo semanal de Julieta fue de: " + sueldoSemanal);
    }
}
