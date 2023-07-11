public abstract class Vendedor {
    protected int ventas;
    protected int puntos;
    protected String categoria;
    protected String nombre;

    public Vendedor(String nombre) {
        this.nombre = nombre;
        this.ventas = 0;
        this.puntos = 0;
    }

    public String mostrarCategoria(){
        calcularPuntos();
        recategorizar();
        return toString();
    }
    public void recategorizar(){
        if (this.puntos<20) {
            this.categoria = "novatos";
        }
        else
            if (this.puntos<=30) {
                this.categoria = "aprendices";
            }
            else
                if (this.puntos<=40) {
                    this.categoria = "buenos";
                }
                else {
                    this.categoria = "maestros";
                }
       };
    public void vender(){this.ventas++;};
    public abstract void calcularPuntos();

    @Override
    public String toString() {
        return this.nombre + " tiene un total de " + this.puntos + ", categoriza como " + this.categoria;
    }
}
