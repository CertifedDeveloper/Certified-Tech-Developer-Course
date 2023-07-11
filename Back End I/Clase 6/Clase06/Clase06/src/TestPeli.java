import excepciones.PeliculaNoHabilitadaException;
import model.IP;
import model.Pelicula;
import service.impl.GrillaDePeliculas;
import service.impl.GrillaDePeliculasProxy;

public class TestPeli {
    public static void main(String[] args) {
        GrillaDePeliculas grilla = new GrillaDePeliculas();
        GrillaDePeliculasProxy proxy = new GrillaDePeliculasProxy(new IP(100,20,20,33), grilla);

        try {
            Pelicula laPeri = proxy.getPelicula("Titanic");
            System.out.println(laPeri.getLink());
        } catch (PeliculaNoHabilitadaException e) {
            System.out.println("No puede verla por su pais");;
        }

    }
}
