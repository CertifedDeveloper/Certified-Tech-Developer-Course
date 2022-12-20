public class Portal implements Observador{
    private String nombre;

    public Portal(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void actualizar(String notificacion) {
        System.out.println(nombre + ": " + notificacion);
    }
}
