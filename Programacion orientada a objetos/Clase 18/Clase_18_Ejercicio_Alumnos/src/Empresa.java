import java.util.ArrayList;

public class Empresa {
    private ArrayList<Reserva> listaReservas;

    public Empresa() {
        listaReservas = new ArrayList<>();
    }
    public void agregarReserva(Reserva reserva){
        listaReservas.add(reserva);
    }
    public double recaudarTotal(){
        double suma = 0;
        for (Reserva reserva: listaReservas){
            suma += reserva.calcularPrecio();
        }
        return suma;
    }
    public int calcularCantidadRecorrida(Estacion estacion) throws CustomException{
        int suma = 0;
        for (Reserva reserva: listaReservas){
            if (reserva.getRecorrido().getEstacionDestino().getNombre().equals(estacion.getNombre()) || reserva.getRecorrido().getEstacionPartida().getNombre().equals(estacion.getNombre())){
                suma++;
            } else {
                throw new CustomException("La estación no se encuentra en la lista de reservas");
            }
        }
        return suma;
    }
}
