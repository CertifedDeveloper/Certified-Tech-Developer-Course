public class Administrador {
    public static void main(String[] args){

        Componente videoA = new Video("videoA");
        Componente videoB = new Video("videoB");
        Componente textoA = new Texto("textoA");
        Componente textoB = new Texto("textoB");
        Componente carpetaA = new Carpeta("carpetaA");
  
        Carpeta carpeta = new Carpeta("Carpeta");
          carpeta.agregarComponente(videoA);
          carpeta.agregarComponente(videoB);
          carpeta.agregarComponente(textoA);
          carpeta.agregarComponente(textoB);
          carpeta.agregarComponente(carpetaA);
  
          carpeta.getContenido();
    }
}
