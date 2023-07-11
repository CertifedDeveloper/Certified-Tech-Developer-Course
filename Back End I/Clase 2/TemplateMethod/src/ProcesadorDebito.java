public class ProcesadorDebito extends ProcesadorPago{
    @Override
    protected boolean autorizar(Tarjeta tarjeta, Double monto) {
        if (((TarjetaDebito)tarjeta).getSaldoDisponible() >= monto){
            return true;
        }
        return false;
    }
}
