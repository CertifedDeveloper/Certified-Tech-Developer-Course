public class Proxy implements ServicioDescarga{
    private Servicio servicio;

    public Proxy() {
        this.servicio = new Servicio();
    }

    @Override
    public String descargar(Usuario usuario) {
        if (usuario.getTipo().compareTo(Tipo.Premium) == 0)
            return servicio.descargar(usuario);
        return "No se permite la descarga";
    }
}
