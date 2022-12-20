public class Triangulo implements Componente{
    private int base;
    private int altura;

    public Triangulo() {
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setBase(int base) {
        this.base = base;
    }

    @Override
    public double calcularArea() {
        return (base * altura) / 2;
    }
}
