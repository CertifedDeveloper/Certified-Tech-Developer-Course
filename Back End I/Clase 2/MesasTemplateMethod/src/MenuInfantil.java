public class MenuInfantil extends Menu{
    private int cantidadJuguetes;

    public MenuInfantil(double precioBase, int cantidadJuguetes) {
        super(precioBase);
        this.cantidadJuguetes = cantidadJuguetes;
    }

    @Override
    protected void armarMenu() {
        System.out.println("Armado del Menú Infantil (Cantidad de Juguetes: " + cantidadJuguetes + " )");
    }

    @Override
    public double calcularPrecioVenta() {
        return super.calcularPrecioVenta() + 3 * cantidadJuguetes;
    }
}
