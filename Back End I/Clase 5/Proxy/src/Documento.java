import java.util.ArrayList;

public class Documento {
    private Integer id;
    private String url;
    private String contenido;
    private ArrayList<String> usuariosAutorizados;

    public Documento(Integer id, String url, String contenido) {
        this.id = id;
        this.url = url;
        this.contenido = contenido;
        this.usuariosAutorizados = new ArrayList<String>();
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<String> getUsuariosAutorizados() {
        return usuariosAutorizados;
    }

    public Integer getId() {
        return id;
    }
}
