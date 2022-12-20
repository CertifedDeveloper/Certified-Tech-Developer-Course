package com.camada15.clase22;

public class MainB {
    public static void main(String[] args) {
        try{
            Producto p1 = ProductoFactory.getInstancia().crearProducto("ProductoIndividual");
            p1.setNombre("Hamburguesa con queso");
            p1.setPrecio(1050);
            Producto p2 = ProductoFactory.getInstancia().crearProducto("ProductoIndividual");
            p2.setNombre("Papaas fritas medianas");
            p2.setPrecio(950);
            Producto combo1 = ProductoFactory.getInstancia().crearProducto("Combo");
            combo1.setNombre("Combo 1");
            ((Combo)combo1).setDescuento(0.2);
            ((Combo)combo1).getProductos().add(p1);
            ((Combo)combo1).getProductos().add(p2);
            Pedido pedidoLu = new Pedido(1);
            pedidoLu.getProductosPedido().add(combo1);
            pedidoLu.getProductosPedido().add(p1);
            System.out.println(pedidoLu.calcularTotal());
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
