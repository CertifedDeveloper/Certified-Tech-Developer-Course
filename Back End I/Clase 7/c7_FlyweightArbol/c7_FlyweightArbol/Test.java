package com.backend.c7_FlyweightArbol;

public class Test {

    public static void main(String[] args) {

        ArbolFactory arbolFactory = new ArbolFactory();

        Arbol a1 = arbolFactory.plantarArbol("ornamental");
        Arbol a2 = arbolFactory.plantarArbol("frutales");
        Arbol a3 = arbolFactory.plantarArbol("florales");
        Arbol a4 = arbolFactory.plantarArbol("ornamental");

        //muestre 1.000.000 de árboles la mitad rojo y la otra mitad verde y que luego informe por pantalla
        // los árboles y cuanta memoria se está usando.

        for (int i = 0; i <10; i++) {
            arbolFactory.plantarArbol("frutal");
        }

        arbolFactory.mostrar();

        //Metodo memoria
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Memoria usada: " + (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));

    }
}
