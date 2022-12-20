public class Nave extends Objeto{
    private double velocidad;
    private int vida;

    public Nave(int x, int y, char direccion, double velocidad) {
        super(x, y, direccion);
        this.velocidad = velocidad;
    }
    @Override
    public void irA(int x, int y, char direccion){
        girar(direccion);
        setX(x);
        setY(y);
    }
    public void girar(char direccion){
        if (getDireccion() != direccion){
            setDireccion(direccion);
        }
    }
    public void restaVida(int valor){
        setVida(getVida() - valor);
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
