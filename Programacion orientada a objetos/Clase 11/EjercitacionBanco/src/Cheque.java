import java.time.LocalDate;

public class Cheque {
    private double monto;
    private String bancoEmisor;
    private LocalDate fechaPago;

    public Cheque(double monto, String bancoEmisor, LocalDate fechaPago) {
        this.monto = monto;
        this.bancoEmisor = bancoEmisor;
        this.fechaPago = fechaPago;
    }

    public double getMonto() {
        return monto;
    }
}
