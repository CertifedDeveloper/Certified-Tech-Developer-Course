import java.util.ArrayList;

public class Vacio implements StateCarrito{
    private Carrito c;

    public Vacio(Carrito c) {
        this.c = c;
        c.setProductos(new ArrayList<>());
    }

    public void cancelar(){
        System.out.println("El carrito ya está vacío");
    }
    public void volver(){
        System.out.println("El carrito ya está vacío.  Agregue productos.");
    }
    public void seguir(){
        System.out.println("El carrito se carga con productos");
        c.setEstado(new Cargando(c));
    }
}
