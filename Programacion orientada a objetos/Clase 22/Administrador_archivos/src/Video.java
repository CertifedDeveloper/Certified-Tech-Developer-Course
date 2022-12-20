public class Video implements Componente {
    private Carpeta carpeta;
    private String nombre;

    public Video(String nombre) {
        this.nombre = nombre;
    }

    public void setCarpeta(Carpeta carpeta) {
        this.carpeta = carpeta;
    }

    public Carpeta getCarpeta() {
        return carpeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void getContenido(){
        System.out.println("El nombre de archivo de video es: " + nombre + "\n" +
                "Está en la carpeta: " + carpeta.getNombre() + "\n");
        System.out.println("------------------------------------------------------------");
    }

}
