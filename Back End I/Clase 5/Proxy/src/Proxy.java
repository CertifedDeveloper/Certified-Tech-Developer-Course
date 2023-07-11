import java.util.ArrayList;

public class Proxy implements ServiceInterface{
    private Service servicio;
    private ArrayList<String> registroDeAcceso;

    public Proxy() {
        this.servicio = new Service();
        this.registroDeAcceso = new ArrayList<String>();
    }

    @Override
    public void acceder(String url, String email) {
        Boolean usuarioEstaAutorizado = Boolean.FALSE;
        Boolean documentoEncontrado = Boolean.FALSE;
        for (Documento documento: servicio.getDocumentos()) {
            if (documento.getUrl().equals(url)){
                documentoEncontrado = Boolean.TRUE;
                for (String usuario: documento.getUsuariosAutorizados()) {
                    if (usuario.equals(email)) {
                        usuarioEstaAutorizado = Boolean.TRUE;
                    }
                }
            }
        }
        if (documentoEncontrado){
            if (usuarioEstaAutorizado) {
                registroDeAcceso.add(email);
                System.out.println("Accediendo al documento " + url + " del usuario " + email);
            } else {
                System.out.println("El usuario " + email + " no tiene acceso al documento " + url);
            }
        } else {
            System.out.println("El documento no se encontró.");
        }
    }

    public ArrayList<String> getRegistroDeAcceso() {
        return registroDeAcceso;
    }

    public Service getServicio() {
        return servicio;
    }
}
