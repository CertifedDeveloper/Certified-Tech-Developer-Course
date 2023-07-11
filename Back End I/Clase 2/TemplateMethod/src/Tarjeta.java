import java.time.LocalDate;

public class Tarjeta {
    private String numeroFrente;
    private String codigoSeguridad;
    private LocalDate fechaExpiracion;

    public Tarjeta(String numeroFrente, String codigoSeguridad, LocalDate fechaExpiracion) {
        this.numeroFrente = numeroFrente;
        this.codigoSeguridad = codigoSeguridad;
        this.fechaExpiracion = fechaExpiracion;
    }

    public LocalDate getFechaExpiracion() {
        return fechaExpiracion;
    }
}
