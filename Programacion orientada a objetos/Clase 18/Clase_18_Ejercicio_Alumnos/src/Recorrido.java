public class Recorrido {
    private Estacion estacionDestino;
    private Estacion estacionPartida;

    public Recorrido(Estacion estacionDestino, Estacion estacionPartida) {
        this.estacionDestino = estacionDestino;
        this.estacionPartida = estacionPartida;
    }

    public Estacion getEstacionDestino() {
        return estacionDestino;
    }

    public Estacion getEstacionPartida() {
        return estacionPartida;
    }
}
