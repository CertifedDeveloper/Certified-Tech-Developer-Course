import java.util.ArrayList;
import java.util.List;

public class Vuelo implements Observable {
    private String vuelo;
    private List<Observador> observadores = new ArrayList<>();

    public Vuelo(String origen, String destino, String hora) {
        vuelo = origen + " - " + destino + ", " + hora;
    }

    @Override
    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void quitarObservador(Observador o) {
        observadores.remove(o);
    }

    @Override
    public void notificar() {
        for (Observador observador: observadores){
            observador.actualizar(vuelo);
        }
    }
}
