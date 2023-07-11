public abstract class Usuario {
    private Usuario siguienteUsuario;
    public abstract void leerDocumento(Documento documento);
    public void setSiguienteUsuario(Usuario siguienteUsuario){
        this.siguienteUsuario = siguienteUsuario;
    }
    public Usuario getSiguienteUsuario(){
        return siguienteUsuario;
    }
}
