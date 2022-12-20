public class Rojo implements StateSemaforo{
    private Semaforo semaforo;

    public Rojo(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void mostrarAviso() {
        System.out.println("El semáforo está en rojo");
    }

    @Override
    public void cambiarEstado() {
        semaforo.setEstado(new Verde(semaforo));
        System.out.println("El semáforo pasa a verde");
    }
}
