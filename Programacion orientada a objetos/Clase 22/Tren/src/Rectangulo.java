public class Rectangulo implements Componente{
    private int alto;
    private int largo;

    public Rectangulo() {
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    @Override
    public double calcularArea() {
        return alto * largo;
    }
}
