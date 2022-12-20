public interface Observable {
    public void agregarObservador(Observador o);
    public void quitarObservador(Observador o);
    public void notificar();
}
