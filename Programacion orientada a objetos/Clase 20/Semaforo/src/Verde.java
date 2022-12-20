public class Verde implements StateSemaforo{
    private Semaforo semaforo;

    public Verde(Semaforo semaforo) {
        this.semaforo = semaforo;
    }

    @Override
    public void mostrarAviso() {
        System.out.println("El semáforo está en verde");
    }

    @Override
    public void cambiarEstado() {
        semaforo.setEstado(new Amarillo(semaforo));
        System.out.println("El semáforo pasa a amarillo");
    }
}
