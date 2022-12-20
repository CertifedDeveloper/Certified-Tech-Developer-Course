public class Semaforo {
    private StateSemaforo estado;

    public Semaforo() {
        this.setEstado(new Verde(this));
    }

    public void setEstado(StateSemaforo estado) {
        this.estado = estado;
    }

    public StateSemaforo getEstado() {
        return estado;
    }
    public void mostrarAviso(){
        getEstado().mostrarAviso();
    }
    public void cambiarEstado(){
        getEstado().cambiarEstado();
    }
}
