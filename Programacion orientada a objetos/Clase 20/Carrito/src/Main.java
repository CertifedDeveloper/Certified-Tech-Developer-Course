public class Main {
    public static void main(String[] args) {
        Producto producto = new Producto("Producto", 1000.);
        Producto productoB = new Producto("ProductoB", 2000.);
        Carrito carrito = new Carrito();
        carrito.agregarProducto(producto);
        carrito.cancelar();
        carrito.agregarProducto(producto);
        carrito.agregarProducto(productoB);
        System.out.println(carrito);
        carrito.volver();
        System.out.println(carrito);
        carrito.agregarProducto(producto);
        carrito.seguir();
        carrito.volver();
        carrito.seguir();
        carrito.seguir();
        carrito.volver();
        carrito.seguir();
    }
}