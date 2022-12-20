public class Curso extends OfertaAcademica{
    private int cargaHoraria;
    private int mesesDuracion;
    private double valorHora;

    public Curso(String nombre, String descripcion, int cargaHoraria, int mesesDuracion, double valorHora) {
        super(nombre, descripcion);
        this.cargaHoraria = cargaHoraria;
        this.mesesDuracion = mesesDuracion;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularPrecio() {
        double precio = cargaHoraria * mesesDuracion * valorHora;
        setPrecio(precio);
        return precio;
    }
}
