public class Serie implements ISerie{
    @Override
    public String getPelicula(String nombre) {
        return "www." + nombre;
    }
}
