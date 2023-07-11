import java.util.ArrayList;

public class Service implements ServiceInterface{
    private ArrayList<Documento> documentos;

    public Service() {
        this.documentos = new ArrayList<Documento>();
    }

    @Override
    public void acceder(String url, String email) {
        System.out.println("Accediendo al documento " + url + " del usuario "+ email);
    }

    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }
}
