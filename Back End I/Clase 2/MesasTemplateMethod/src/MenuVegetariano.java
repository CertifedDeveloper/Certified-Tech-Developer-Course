public class MenuVegetariano extends Menu{
    private boolean especias;
    private int salsavegetariana;

    public MenuVegetariano(double precioBase, boolean especias, int salsavegetariana) {
        super(precioBase);
        this.especias = especias;
        this.salsavegetariana = salsavegetariana;
    }

    @Override
    protected void armarMenu() {
        String tieneEspecias = "No";
        if (especias){
            tieneEspecias = "Sí";
        }
        System.out.println("Armado del Menú Vegetariano (Especias: " + tieneEspecias + ", Cantidad de salsas: " + salsavegetariana + " )");
    }

    @Override
    public double calcularPrecioVenta() {
        return super.calcularPrecioVenta() * 1.01 + 2 * salsavegetariana;
    }
}
