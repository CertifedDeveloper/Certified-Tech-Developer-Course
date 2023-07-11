import java.util.ArrayList;

public class AuthenticationService {
    private ArrayList<String> DNIValidos;
    private ArrayList<String> contraseniasValidas;

    public AuthenticationService() {
        this.DNIValidos = new ArrayList<>();
        this.contraseniasValidas = new ArrayList<>();
    }

    public boolean validarUsuarioYContrasenia(String DNI, String contrasenia){
        boolean DNIEsValido = false;
        boolean contraseniaEsValida = false;
        for (String DNIValido : DNIValidos){
            if (DNIValido.equalsIgnoreCase(DNI)){
                DNIEsValido = true;
                for (String contraseniaValida : contraseniasValidas){
                    if (contraseniaValida.equalsIgnoreCase(contrasenia)){
                        contraseniaEsValida = true;
                    }
                }
            }
        }
        if (DNIEsValido){
            System.out.println("Usuario válido");
            if (contraseniaEsValida){
                System.out.println("Contraseña válida");
                return true;
            } else {
                System.out.println("Contraseña inválida");
            }
        } else {
            System.out.println("DNI inválido");
        }
        return false;
    }
    public void agregarUsuarioYContrasenia(String DNI, String contrasenia){
        DNIValidos.add(DNI);
        contraseniasValidas.add(contrasenia);
    }
}
