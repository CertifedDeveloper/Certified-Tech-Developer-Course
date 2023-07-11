package com.backend.c7_FlyweightArbol;

public class Arbol {

    private double alto;
    private double ancho;
    private String color;
    private String tipo;

    private int contador;

    public Arbol(String tipo) {
        this.tipo = tipo;
    }

    public void incrementa(){
        this.contador++;
    }

    @Override
    public String toString() {
        return "Arbol" + '\n' +
                " color ='" + color + '\n' +
                " tipo = " + tipo + '\n' +
                " contador =" + contador;
    }

    public void setAlto(double alto) {
        this.alto = alto;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
