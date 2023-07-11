import java.util.ArrayList;

public class SerieProxy implements ISerie{
    private ArrayList<String> listaHabilitadas;
    private ArrayList<Integer> cantVistas;
    private Serie serie;

    public SerieProxy() {
        this.listaHabilitadas = new ArrayList<String>();
        this.cantVistas = new ArrayList<Integer>();
        this.serie = new Serie();
    }

    @Override
    public String getPelicula(String nombre) throws SerieNoHabilitadaException{
        if (cantVistas.get(listaHabilitadas.indexOf(nombre)) < 5){
            cantVistas.set(listaHabilitadas.indexOf(nombre),cantVistas.get(listaHabilitadas.indexOf(nombre))+1);
            System.out.println(serie.getPelicula(nombre));
            return serie.getPelicula(nombre);
        }
        throw new SerieNoHabilitadaException("Ha superado la cantidad de reproducciones permitidas");
    }
    public void agregarSerie(String nombre){
        listaHabilitadas.add(nombre);
        cantVistas.add(0);
    }
}
