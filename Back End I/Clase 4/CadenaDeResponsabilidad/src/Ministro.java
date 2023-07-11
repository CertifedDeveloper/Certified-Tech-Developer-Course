public class Ministro extends Usuario{
    @Override
    public void leerDocumento(Documento documento) {
        setSiguienteUsuario(new Presidente());
        if (documento.getTipo().equals(1) || documento.getTipo().equals(2)){
            System.out.println("Documento  del tipo " + documento.getTipo() + " leído por el Ministro.");
        }
        getSiguienteUsuario().leerDocumento(documento);
    }
}
