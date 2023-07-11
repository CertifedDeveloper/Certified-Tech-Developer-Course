import java.io.Serializable;

public class Contactos implements Serializable {
    private String nombre;
    private String mail;
    private String telefono;

    public Contactos(String nombre, String mail, String telefono) {
        this.nombre = nombre;
        this.mail = mail;
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Contactos{" +
                "nombre='" + nombre + '\'' +
                ", mail='" + mail + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
