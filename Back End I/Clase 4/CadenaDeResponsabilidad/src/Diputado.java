public class Diputado extends Usuario{
    @Override
    public void leerDocumento(Documento documento) {
        setSiguienteUsuario(new Ministro());
        if (documento.getTipo().equals(1)){
            System.out.println("Documento del tipo " + documento.getTipo() + " leído por el Diputado.");
        }
        getSiguienteUsuario().leerDocumento(documento);
    }
}
