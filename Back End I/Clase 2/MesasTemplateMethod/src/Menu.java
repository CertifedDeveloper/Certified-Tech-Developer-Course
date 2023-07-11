public abstract class Menu {
    private double precioBase;

    public Menu(double precioBase) {
        this.precioBase = precioBase;
    }

    public void prepararMenu(){
        armarMenu();
        System.out.println("El precio de venta es: " + calcularPrecioVenta());
        System.out.println("---------------------------------------------------");
    };
    protected abstract void armarMenu();
    public double calcularPrecioVenta(){
        return precioBase;
    };
}
