package com.backend.c7_FlyweightArbol;

import com.backend.c7_FlyweightComputadora.model.Computadora;

import java.util.HashMap;

public class ArbolFactory {

    private HashMap<String, Arbol> arboles = new HashMap<>();

    public Arbol plantarArbol(String tipo){
        int contador=0;

        if(!arboles.containsKey(tipo)){

            Arbol arbol = new Arbol(tipo);

            if(tipo.equalsIgnoreCase("ornamental")){
                System.out.println("Creando un arbol ornamental");
                arbol.setAlto(200);
                arbol.setAncho(400);
                arbol.setColor("verde");
            }
            if(tipo.equalsIgnoreCase("frutales")){
                System.out.println("Creando un arbol frutal");
                arbol.setAlto(500);
                arbol.setAncho(300);
                arbol.setColor("rojo");
            }
            if(tipo.equalsIgnoreCase("florales")){
                System.out.println("Creando un arbol floral");
                arbol.setAlto(100);
                arbol.setAncho(200);
                arbol.setColor("celeste");
            }
            arboles.put(tipo, arbol);
        }
        Arbol arbol = arboles.get(tipo);
        arbol.incrementa();
        System.out.printf("Plantando arbol");
        return arbol;

    }

    public void  mostrar(){
        System.out.println(arboles.get("ornamental"));
        System.out.println(arboles.get("frutales"));
        System.out.println(arboles.get("florales"));
    }

}
