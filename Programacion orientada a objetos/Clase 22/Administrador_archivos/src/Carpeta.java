import java.util.ArrayList;
import java.util.List;

public class Carpeta implements Componente {
    private String nombre;
    private Carpeta carpeta;
    private List<Componente> archivos;

    public Carpeta(String nombre) {
        this.nombre = nombre;
        this.archivos = new ArrayList<>();
        this.carpeta = null;
    }

    public void setNombre(String name) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public Carpeta getCarpeta() {
        return this;
    }

    @Override
    public void setCarpeta(Carpeta carpeta) {
        this.carpeta = carpeta;
    }

    public List<Componente> getArchivos() {
        return archivos;
    }

    public void getContenido() {

        for (Componente componente: archivos){
            if (componente.getClass().getName().equals("Carpeta")) {
                if (((Carpeta) componente).archivos.size() == 0) {
                    System.out.println("El nombre de la carpeta es: " + componente.getNombre() + "\n" +
                            "y está vacía.");
                } else {
                    System.out.println("El nombre de la carpeta es: " + componente.getNombre() + "\n" +
                            "y contiene lo siguiente: " + "\n");
                    for (Componente elemento: ((Carpeta) componente).archivos){
                        elemento.getContenido();
                    }
                }
            }else {
                componente.getContenido();
            }
        }
    }
    public boolean estaEnCarpeta(Carpeta carpeta, Componente componente){
        boolean existe = false;
        for (Componente archivo: archivos){
            if(archivo.getNombre().equals(componente.getNombre())) existe = true;
        }
        return existe;
    }

    public void agregarComponente(Componente componente) {
        Carpeta carpeta = this;
        if (componente != null && !estaEnCarpeta(carpeta, componente)) {
            componente.setCarpeta(carpeta);
            archivos.add(componente);
        }
    }

    public void removerComponente(Componente componente) {
        if (componente != null || estaEnCarpeta(this, componente)) {
            if (componente.getClass().getName().equals("Carpeta")){
                for (Componente elemento: componente.getCarpeta().getArchivos()){
                    removerComponente(elemento);
                }
                componente.setNombre("");
                componente.setCarpeta(null);
                archivos.remove(componente);
            } else {
                componente.setNombre("");
                componente.setCarpeta(null);
                archivos.remove(componente);
            }
        }
    }
}
