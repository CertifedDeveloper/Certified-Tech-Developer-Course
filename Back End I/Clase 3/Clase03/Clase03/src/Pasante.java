public class Pasante extends Vendedor{
    public Pasante(String nombre) {
        super(nombre);
    }

    @Override
    public void recategorizar() {
        if (this.puntos<50)
            this.categoria = "novato";
        else
            this.categoria = "experimentado";
    }

    @Override
    public void calcularPuntos() {
        this.puntos =5 * this.ventas;
    }
}
