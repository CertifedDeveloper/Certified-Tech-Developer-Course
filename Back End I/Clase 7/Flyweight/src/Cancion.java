import java.util.ArrayList;

public class Cancion {
    private String nombre;
    private String artista;
    private String genero;
    private ArrayList<ListaReproduccion> lista;

    public Cancion() {
        this.lista = new ArrayList<>();
    }

    public ArrayList<ListaReproduccion> getLista() {
        return lista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setArtista(String artista) {
        this.artista = artista;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        String elemento = " ";
        for (ListaReproduccion listaReproduccion : lista){
            elemento += listaReproduccion.getNombre() +  "\n";
        }
        return "Listas de reproducción de la canción " + nombre + "\n" +
                elemento +
        "--------------------------------------------------------";
    }
}
