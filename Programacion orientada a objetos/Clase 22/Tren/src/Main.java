public class Main {
    public static void main(String[] args) {
        try{
            Componente rectanguloA = ComponenteFactory.getInstancia().crearComponente("Rectangulo");
            ((Rectangulo)rectanguloA).setAlto(4);
            ((Rectangulo)rectanguloA).setLargo(5);
            Componente circuloA = ComponenteFactory.getInstancia().crearComponente("Circulo");
            ((Circulo)circuloA).setRadio(1);
            Componente vagon = ComponenteFactory.getInstancia().crearComponente("Vagon");
            ((Vagon)vagon).agregarComponente(rectanguloA);
            ((Vagon)vagon).agregarComponente(circuloA);
            System.out.println(vagon.calcularArea());
        }catch (Exception e){
            System.out.println(e);
        }
        try{
            Componente rectanguloB = ComponenteFactory.getInstancia().crearComponente("Rectangulo");
            ((Rectangulo)rectanguloB).setAlto(4);
            ((Rectangulo)rectanguloB).setLargo(6);
            Componente circuloA = ComponenteFactory.getInstancia().crearComponente("Circulo");
            Componente circuloB = ComponenteFactory.getInstancia().crearComponente("Circulo");
            ((Circulo)circuloA).setRadio(1);
            ((Circulo)circuloB).setRadio(1);
            Componente trianguloA = ComponenteFactory.getInstancia().crearComponente("Triangulo");
            ((Triangulo)trianguloA).setAltura(2);
            ((Triangulo)trianguloA).setBase(2);
            Componente locomotora = ComponenteFactory.getInstancia().crearComponente("Locomotora");
            ((Locomotora)locomotora).agregarComponente(rectanguloB);
            ((Locomotora)locomotora).agregarComponente(circuloA);
            ((Locomotora)locomotora).agregarComponente(circuloB);
            ((Locomotora)locomotora).agregarComponente(trianguloA);
            System.out.println(locomotora.calcularArea());
        }catch (Exception e){
            System.out.println(e);
        }
    }
}