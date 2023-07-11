public class Arbol {
    private int ancho;
    private int alto;
    private String color;
    private String tipoDeArbol;
    private int contador;

    public Arbol(String tipoDeArbol) {
        this.tipoDeArbol = tipoDeArbol;
    }
    public void incrementar(){
        contador++;
    }

    public int getContador() {
        return contador;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
