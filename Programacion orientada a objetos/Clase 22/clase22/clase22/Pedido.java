package com.camada15.clase22;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private List<Producto> productosPedido;

    public Pedido(int numero) {
        this.numero = numero;
        productosPedido = new ArrayList<>();
    }

    public Pedido(int numero, List<Producto> productosPedido) {
        this.numero = numero;
        this.productosPedido = productosPedido;
    }

    public List<Producto> getProductosPedido() {
        return productosPedido;
    }

    public double calcularTotal(){
        double total = 0;
        for (Producto producto : productosPedido){
            total += producto.calcularPrecio();
        }
        return total;
    }

}
