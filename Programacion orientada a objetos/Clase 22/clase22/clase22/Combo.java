package com.camada15.clase22;

import java.util.ArrayList;
import java.util.List;

public class Combo extends Producto{
    private double descuento;
    private List<Producto> productos = new ArrayList<>();

    public Combo(){
    }
    public Combo(String nombre, double precio, double descuento) {
        super(nombre, precio);
        this.descuento = descuento;
        productos = new ArrayList<>();
    }
    public List<Producto> getProductos() {
        return productos;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public double calcularPrecio(){
        double total = 0;
        for (Producto producto : productos){//por cada elemento (p) de tipo Producto que se encuentra dentro de la lista "productos"...
            total += producto.calcularPrecio();
        }
        total = total - (total*descuento);
        setPrecio(total);
        return  total;
    }

    @Override
    public String toString(){
        return "---------- COMBO ----------" + "\n" + super.toString() + "\n" + "Descuento: " + descuento;
    }
}
