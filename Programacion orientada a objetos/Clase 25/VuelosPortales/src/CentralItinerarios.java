import java.util.ArrayList;
import java.util.List;

public class CentralItinerarios {
    private List<Vuelo> vuelos = new ArrayList<>();

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void notificarVuelos(){
        System.out.println("---------------------Vuelos----------------------");
        for (Vuelo vuelo: vuelos){
            vuelo.notificar();
        }
    }
}
