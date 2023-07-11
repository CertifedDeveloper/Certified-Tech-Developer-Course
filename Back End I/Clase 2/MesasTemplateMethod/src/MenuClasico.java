public class MenuClasico extends Menu{
    public MenuClasico(double precioBase) {
        super(precioBase);
    }

    @Override
    protected void armarMenu() {
        System.out.println("Armado del Menú Clásico (No tiene recargos)");
    }
}
