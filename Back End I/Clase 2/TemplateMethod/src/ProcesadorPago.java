import java.time.LocalDate;

public abstract class ProcesadorPago {

    public void procesarPago(Tarjeta tarjeta, Double monto){
        if (validarFecha(tarjeta) && autorizar(tarjeta, monto)){
            System.out.println("El pago fue autorizado.");
        } else{
            System.out.println("El pago no fue autorizado.");
        }
    }
    private boolean validarFecha(Tarjeta tarjeta){
        if (tarjeta.getFechaExpiracion().isAfter(LocalDate.now())){
            return true;
        }
        return false;
    }
    protected abstract boolean autorizar(Tarjeta tarjeta, Double monto);
}
