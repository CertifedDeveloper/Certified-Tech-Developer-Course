import java.util.ArrayList;
import java.util.List;

public class Carrito{
    private List<Producto> productos;
    private StateCarrito estado;

    public Carrito() {
        this.setEstado(new Vacio(this));
    }
    public void agregarProducto(Producto producto){
        productos.add(producto);
        if (getEstado().getClass().getName().equals("Vacio")) seguir();
    }
    public void setEstado(StateCarrito estado) {
        this.estado = estado;
    }
    public StateCarrito getEstado() {
        return estado;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void cancelar(){
        getEstado().cancelar();
    }
    public void volver(){
        getEstado().volver();
    }
    public void seguir(){
        getEstado().seguir();
    }

    @Override
    public String toString() {
        return "Los productos son: " + "\n" +
                getProductos();
    }
}
