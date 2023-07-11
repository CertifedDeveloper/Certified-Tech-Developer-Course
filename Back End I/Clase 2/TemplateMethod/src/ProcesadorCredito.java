public class ProcesadorCredito extends ProcesadorPago{
    @Override
    protected boolean autorizar(Tarjeta tarjeta, Double monto) {
        if (monto <= ((TarjetaCredito)tarjeta).getLimite()){
            return true;
        }
        return false;
    }
}
