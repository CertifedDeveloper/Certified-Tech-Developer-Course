public class Presidente extends Usuario{
    @Override
    public void leerDocumento(Documento documento) {
        if (documento.getTipo().equals(1) || documento.getTipo().equals(2) || documento.getTipo().equals(3)){
            System.out.println("Documento  del tipo " + documento.getTipo() + " leído por el Presidente.");
        }
    }
}
