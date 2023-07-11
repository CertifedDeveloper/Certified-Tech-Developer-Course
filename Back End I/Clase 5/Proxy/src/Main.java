
public class Main {
    public static void main(String[] args) {
        ServiceInterface proxy = new Proxy();
        Documento documentoA = new Documento(1,"documentoA.com", "contenidoA");
        Documento documentoB = new Documento(2,"documentoB.com", "contenidoB");
        String usuarioAutorizadoA = "emailA.com";
        String usuarioAutorizadoB = "emailB.com";
        documentoA.getUsuariosAutorizados().add(usuarioAutorizadoA);
        documentoA.getUsuariosAutorizados().add(usuarioAutorizadoB);
        documentoB.getUsuariosAutorizados().add(usuarioAutorizadoB);
        ((Proxy)proxy).getServicio().getDocumentos().add(documentoA);
        ((Proxy)proxy).getServicio().getDocumentos().add(documentoB);
        proxy.acceder("documentoA.com", "emailA.com");
        proxy.acceder("documentoA.com", "emailB.com");
        proxy.acceder("documentoB.com", "emailA.com");
        proxy.acceder("documentoB.com", "emailB.com");
        proxy.acceder("documentoC.com", "emailA.com");
        System.out.println("---------------Registro de acceso---------------");
        System.out.println(((Proxy) proxy).getRegistroDeAcceso());
    }
}