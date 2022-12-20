public class Pagando implements StateCarrito{
    private Carrito c;

    public Pagando(Carrito c) {
        this.c = c;
    }

    public void cancelar(){
        System.out.println("El carrito se cancela.  Vuelve a estar vacío");
        c.setEstado(new Vacio(c));
    }
    public void volver(){
        System.out.println("El carrito pasa al estado Cargando");
        c.setEstado(new Cargando(c));
    }
    public void seguir(){
        System.out.println("El carrito se cierra");
        c.setEstado(new Cerrado(c));
    }
}
