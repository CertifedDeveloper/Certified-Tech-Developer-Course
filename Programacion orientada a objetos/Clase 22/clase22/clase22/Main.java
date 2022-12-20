package com.camada15.clase22;

public class Main {
    public static void main(String[] args) {

        ProductoIndividual p1 = new ProductoIndividual("Hamburguesa con queso", 1050);
        ProductoIndividual p2 = new ProductoIndividual("Papas fritas medianas", 950);

        Combo combo1 = new Combo("Combo 1", 0, 0.2);
        combo1.getProductos().add(p1);
        combo1.getProductos().add(p2);


        Pedido pedidoLu = new Pedido(1);
        pedidoLu.getProductosPedido().add(combo1);
        pedidoLu.getProductosPedido().add(p1);

        System.out.println(pedidoLu.calcularTotal());

    }
}
