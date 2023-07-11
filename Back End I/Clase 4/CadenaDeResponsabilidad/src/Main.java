public class Main {
    public static void main(String[] args) {
        Documento documentoA = new Documento("documentoA", 1);
        Documento documentoB = new Documento("documentoB", 2);
        Documento documentoC = new Documento("documentoC", 3);

        Diputado diputado = new Diputado();
        Ministro ministro = new Ministro();
        Presidente presidente = new Presidente();

        System.out.println("---------------Diputado-----------------");
        diputado.leerDocumento(documentoA);
        diputado.leerDocumento(documentoB);
        diputado.leerDocumento(documentoC);

        System.out.println("---------------Ministro-----------------");
        ministro.leerDocumento(documentoA);
        ministro.leerDocumento(documentoB);
        ministro.leerDocumento(documentoC);

        System.out.println("---------------Presidente-----------------");
        presidente.leerDocumento(documentoA);
        presidente.leerDocumento(documentoB);
        presidente.leerDocumento(documentoC);
    }
}