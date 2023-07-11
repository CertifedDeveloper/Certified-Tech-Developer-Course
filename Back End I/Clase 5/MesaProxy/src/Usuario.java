public class Usuario {
    private int identificador;
    private Enum tipo;

    public Usuario(int identificador, Enum tipo) {
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public Enum getTipo() {
        return tipo;
    }
}
