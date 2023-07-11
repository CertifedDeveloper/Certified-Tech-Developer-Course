import java.time.LocalDate;

public class TarjetaDebito extends Tarjeta{
    private Double saldoDisponible;

    public TarjetaDebito(String numeroFrente, String codigoSeguridad, LocalDate fechaExpiracion, Double saldoDisponible) {
        super(numeroFrente, codigoSeguridad, fechaExpiracion);
        this.saldoDisponible = saldoDisponible;
    }

    public Double getSaldoDisponible() {
        return saldoDisponible;
    }
}
