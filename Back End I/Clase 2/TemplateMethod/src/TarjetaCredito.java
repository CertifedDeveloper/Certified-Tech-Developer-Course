import java.time.LocalDate;

public class TarjetaCredito extends Tarjeta{
    private Double limite;
    private Double saldoUtilizado;

    public TarjetaCredito(String numeroFrente, String codigoSeguridad, LocalDate fechaExpiracion, Double limite, Double saldoUtilizado) {
        super(numeroFrente, codigoSeguridad, fechaExpiracion);
        this.limite = limite;
        this.saldoUtilizado = saldoUtilizado;
    }

    public Double getLimite() {
        return limite;
    }
}
