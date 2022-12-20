import java.util.ArrayList;

public class Cargando implements StateCarrito{
    private Carrito c;

    public Cargando(Carrito c) {
        this.c = c;
    }

    public void cancelar(){
        System.out.println("El carrito se cancela.  Vuelve a estar vacío");
        c.setEstado(new Vacio(c));
    }
    public void volver(){
        System.out.println("El carrito se vacía");
        c.setEstado(new Vacio(c));
    }
    public void seguir(){
        System.out.println("El carrito pasa a el estado Pagando");
        c.setEstado(new Pagando(c));
    }
}
