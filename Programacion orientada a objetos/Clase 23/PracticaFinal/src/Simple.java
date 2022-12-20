public class Simple extends UnidadTrabajo{
    private double montoPersona;
    private int cantidadPersonas;

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

    public void setMontoPersona(double montoPersona) {
        this.montoPersona = montoPersona;
    }

    @Override
    public double calcularMonto() {
        if(cantidadPersonas > 10){
            return montoPersona * cantidadPersonas * 1.2;
        } else {
            return montoPersona * cantidadPersonas;
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "Cantidad de personas: " + cantidadPersonas;
    }
}
