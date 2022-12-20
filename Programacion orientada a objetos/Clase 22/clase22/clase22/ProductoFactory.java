package com.camada15.clase22;

public class ProductoFactory {
    private static ProductoFactory instancia;

    private ProductoFactory() {
    }
    public static ProductoFactory getInstancia(){
        if (instancia == null){
            instancia = new ProductoFactory();
        }
        return instancia;
    }
    public Producto crearProducto(String tipo) throws Exception{
        switch (tipo){
            case "ProductoIndividual":
                ProductoIndividual productoIndividual = new ProductoIndividual();
                productoIndividual.setNombre(tipo);
                productoIndividual.setPrecio(0);
                return productoIndividual;
            case "Combo":
                Combo combo = new Combo();
                combo.setNombre(tipo);
                combo.setPrecio(0);
                return combo;
            default:
                throw new Exception("El producto no existe");
        }
    }
}
