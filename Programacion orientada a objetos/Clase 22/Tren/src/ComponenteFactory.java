public class ComponenteFactory {
    private static ComponenteFactory instancia;

    private ComponenteFactory() {
    }
    public static ComponenteFactory getInstancia(){
        if (instancia == null){
            instancia = new ComponenteFactory();
        }
        return instancia;
    }
    public Componente crearComponente(String tipo) throws Exception{
        switch (tipo){
            case "Triangulo":
                Triangulo t = new Triangulo();
                t.setAltura(0);
                t.setBase(0);
                return t;
            case "Circulo":
                Circulo c = new Circulo();
                c.setRadio(0);
                return c;
            case "Rectangulo":
                Rectangulo r = new Rectangulo();
                r.setAlto(0);
                r.setLargo(0);
                return r;
            case "Vagon":
                Vagon v = new Vagon();
                return v;
            case "Locomotora":
                Locomotora l = new Locomotora();
                return l;
            default:
                throw new Exception("El componente no se encuentra");
        }
    }
}
