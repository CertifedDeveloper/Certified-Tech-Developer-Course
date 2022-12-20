public class Cerrado implements StateCarrito{
    private Carrito c;

    public Cerrado(Carrito c) {
        this.c = c;
    }

    public void cancelar(){
        System.out.println("El carrito se cancela.  Vuelve a estar vacío");
        c.setEstado(new Vacio(c));
    }
    public void volver(){
        System.out.println("El carrito está cerrado.  No se puede volver");
    }
    public void seguir(){
        System.out.println("El carrito vuelve a estar vacío");
        c.setEstado(new Vacio(c));
    }
}
