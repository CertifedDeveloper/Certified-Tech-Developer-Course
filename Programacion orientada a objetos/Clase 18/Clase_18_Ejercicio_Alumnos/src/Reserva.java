public class Reserva {
    private String codigo;
    private int cantidadPersonas;
    private Recorrido recorrido;

    public Reserva(String codigo, int cantidadPersonas, Recorrido recorrido) {
        this.codigo = codigo;
        this.cantidadPersonas = cantidadPersonas;
        this.recorrido = recorrido;
    }

    public Recorrido getRecorrido() {
        return recorrido;
    }

    public double calcularPrecio(){
        double precio;
        if (recorrido.getEstacionPartida().getNombre().equals("Buenos Aires") && recorrido.getEstacionDestino().getNombre().equals("Bragado")){
            precio = 50. * cantidadPersonas * 0.8;
        } else {
            precio = 50. * cantidadPersonas;
        }
        return precio;
    }
}
