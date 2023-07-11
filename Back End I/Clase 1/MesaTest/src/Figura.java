public class Figura {
    private double medida;
    private String tipo;

    public Figura(double medida, String tipo) {
        this.medida = medida;
        this.tipo = tipo;
    }
    public double calcularArea(){
        double area = 0;
        if (medida > 0){
            if (tipo.equals("circulo"))
                area = medida * medida * Math.PI;
            else if (tipo.equals("cuadrado"))
                area = medida * medida;
            System.out.println("El Área de "+ tipo + " es " + area);
            return area;
        }
        else {
            System.out.println("El valor del radio o lado debe ser mayor a cero.");
            return area;
        }

    }
}
