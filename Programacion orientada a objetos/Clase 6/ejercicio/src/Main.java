public class Main {
    public static void main(String[] args) {
        class UsuarioJuego {
            private String nombre;
            private String clave;
            private Double puntaje = 0.;
            private int nivel;
            UsuarioJuego(String nombre, String clave){
                this.nombre = nombre;
                this.clave = clave;
            }
            public void aumentarPuntaje(){
                puntaje++;
            }
            public void subirNivel(){
                nivel++;
            }
            public void bonus(int valor){
                puntaje += valor;
            }
            public Double getPuntaje(){
                return puntaje;
            }
            public int getNivel(){
                return nivel;
            }
        }
        UsuarioJuego usuario = new UsuarioJuego("Hola", "12345");
        System.out.println("Puntaje y nivel antes de incrementar");
        System.out.println(usuario.getPuntaje());
        System.out.println(usuario.getNivel());;
        usuario.aumentarPuntaje();
        usuario.subirNivel();
        System.out.println("Puntaje y nivel después de incrementar");
        System.out.println(usuario.getPuntaje());
        System.out.println(usuario.getNivel());
        System.out.println("Puntaje después de un bonus");
        usuario.bonus(2);
        System.out.println(usuario.getPuntaje());
    }
}