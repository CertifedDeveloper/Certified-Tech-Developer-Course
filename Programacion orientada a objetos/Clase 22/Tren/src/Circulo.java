public class Circulo implements Componente{
    private int radio;

    public Circulo() {
    }

    public void setRadio(int radio) {
        this.radio = radio;
    }

    @Override
    public double calcularArea() {
        return radio * radio * Math.PI;
    }
}
