package com.camada15.clase2;

import java.util.Scanner;

public class ClaseDos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa tu nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingresa tu apellido:");
        String apellido = scanner.nextLine();

        //char inicialN = nombre.charAt(0);
        //char inicialA = apellido.charAt(0);
        String inicialN = String.valueOf(nombre.charAt(0));
        String inicialA = String.valueOf(apellido.charAt(0));
        System.out.println(inicialN + inicialA);
        System.out.println(inicialN.concat(inicialA));

        String iniNom = Character.toString(nombre.charAt(0));

        System.out.println("Ingresa tu dia de nacimiento");
        int diaNac = scanner.nextInt();
        System.out.println("Ingresa tu mes de nacimiento");
        int mesNac = scanner.nextInt();
        System.out.println("Ingresa tu año de nacimiento");
        int anioNac = scanner.nextInt();

        // barra invertida alt+92
        System.out.println("Nombre: " + nombre + " " + apellido + "\nFecha nacimiento: " + mostrarFechaNac(mesNac, diaNac, anioNac));

    }

    static String mostrarFechaNac(int mes, int dia, int anio){

        return dia + "/" + mes + "/" + anio;
    }


}
