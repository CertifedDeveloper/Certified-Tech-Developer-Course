public class Afiliado extends Vendedor{
    public Afiliado(String nombre) {
        super(nombre);
    }
    @Override
    public void calcularPuntos() {
        this.puntos = this.ventas * 15;
    }
}
