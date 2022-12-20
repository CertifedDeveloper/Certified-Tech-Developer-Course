public class Amarillo implements StateSemaforo{
    private Semaforo semaforo;

    public Amarillo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void mostrarAviso() {
        System.out.println("El semáforo está en amarillo");
    }

    @Override
    public void cambiarEstado() {
        semaforo.setEstado(new Rojo(semaforo));
        System.out.println("El semáforo pasa a rojo");
    }
}
