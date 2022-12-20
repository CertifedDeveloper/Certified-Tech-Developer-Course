public abstract class Objeto {
    private int x;
    private int y;
    private char direccion;

    public Objeto(int x, int y, char direccion) {
        this.x = x;
        this.y = y;
        this.direccion = direccion;
    }
    public abstract void irA(int x, int y, char direccion);

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setDireccion(char direccion) {
        this.direccion = direccion;
    }

    public char getDireccion() {
        return direccion;
    }
}
