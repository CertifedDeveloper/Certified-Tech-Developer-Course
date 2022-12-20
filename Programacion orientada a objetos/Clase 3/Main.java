package com.camada15.clase3;

import java.util.Scanner;

public class Main {

    static void calcularCantidadPaquetes(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique el nombre del perro");
        String nombre = scanner.nextLine();
        //System.out.println(nombre);
        System.out.println("Ingrese la cantidad de alimento que consume " + nombre);
        double cantAlimento = scanner.nextDouble();
        //scanner.nextLine(); para limpieza del scanner
        while(cantAlimento<3){
            System.out.println(nombre + " necesita minimo 3 kg por dia de alimento, volve a ingresar la cantidad: ");
             cantAlimento = scanner.nextDouble();
        }

        int cantPaquetes = 0;
        double kilosTotalesPaquetes = 0;

        while(cantAlimento>kilosTotalesPaquetes){
            System.out.println("Ingresa el peso del paquete");
            kilosTotalesPaquetes += scanner.nextDouble();
            cantPaquetes++;
        }
        System.out.println("Se necesitan " + cantPaquetes + " paquetes de alimento para " + nombre + " este satisfecho");

    }

    public static void main(String[] args) {
        calcularCantidadPaquetes();
    }

}
