public class Main {
    public static void main(String[] args) {
        ISerie proxy = new SerieProxy();
        ((SerieProxy)proxy).agregarSerie("peliculaA");
        ((SerieProxy)proxy).agregarSerie("peliculaB");
        ((SerieProxy)proxy).agregarSerie("peliculaC");

        try{
            proxy.getPelicula("peliculaA");
            proxy.getPelicula("peliculaA");
        }
        catch (SerieNoHabilitadaException e){
            System.out.println(e.getMessage());
        }

        try{
            proxy.getPelicula("peliculaB");
            proxy.getPelicula("peliculaB");
            proxy.getPelicula("peliculaB");
            proxy.getPelicula("peliculaB");
            proxy.getPelicula("peliculaB");
        }
        catch(SerieNoHabilitadaException e){
            System.out.println(e.getMessage());
        }

        try{
            proxy.getPelicula("peliculaC");
            proxy.getPelicula("peliculaC");
            proxy.getPelicula("peliculaC");
            proxy.getPelicula("peliculaC");
            proxy.getPelicula("peliculaC");
            proxy.getPelicula("peliculaC");
        } catch (SerieNoHabilitadaException e){
            System.out.println(e.getMessage());
        }

    }
}