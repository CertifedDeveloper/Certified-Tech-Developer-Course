import java.time.LocalDate;

public class Perro {
    private boolean enAdopcion;
    private String raza;
    private int anioNacimiento;
    private double peso;
    private boolean tieneChip;
    private boolean estaLastimado;
    private String nombreDePila;

    public Perro(String nombreDePila, String raza, int anioNacimiento, boolean tieneChip){
        this.nombreDePila = nombreDePila;
        this.raza = raza;
        this.anioNacimiento = anioNacimiento;
        this.tieneChip = tieneChip;
    }

    public Perro(String nombreDePila, String raza, double peso, boolean estaLastimado){
        this.nombreDePila = nombreDePila;
        this.raza = raza;
        this.peso =  peso;
        this.estaLastimado = estaLastimado;
    }

    public boolean isEnAdopcion() {
        return enAdopcion;
    }

    public void setEnAdopcion(boolean enAdopcion) {
        this.enAdopcion = enAdopcion;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isTieneChip() {
        return tieneChip;
    }

    public void setTieneChip(boolean tieneChip) {
        this.tieneChip = tieneChip;
    }

    public boolean isEstaLastimado() {
        return estaLastimado;
    }

    public void setEstaLastimado(boolean estaLastimado) {
        this.estaLastimado = estaLastimado;
    }

    public String getNombreDePila() {
        return nombreDePila;
    }

    public void setNombreDePila(String nombreDePila) {
        this.nombreDePila = nombreDePila;
    }

    public int mostrarEdad(){
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.getYear() - anioNacimiento;
    }

    public boolean poderPerderse(){
        if (tieneChip){
            return false;
        } else {
            return true;
        }
    }

    public void poderAdoptarse(){
        if (estaLastimado == false && peso > 5){
            enAdopcion = true;
        } else {
            enAdopcion = false;
        }
    }
}
