import java.util.ArrayList;

public class Empleado extends Vendedor{

    private ArrayList<Afiliado> losAfiliados = new ArrayList<>();
    private  int antiguedad;
    private int afiliados;

    public Empleado(String nombre, int antiguedad) {
        super(nombre);
        this.antiguedad = antiguedad;
    }

    @Override
    public void calcularPuntos() {
        //    cantidadAfiliados = losAfiliados.size();
            this.puntos = this.antiguedad * 5 + this.afiliados*10 + this.ventas* 5;
    }
    public void agregarAfiliado(Afiliado afiliado){
        this.afiliados++;
        this.losAfiliados.add(afiliado);
    }
}
