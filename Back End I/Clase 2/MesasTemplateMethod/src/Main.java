public class Main {
    public static void main(String[] args) {
        MenuClasico menuClasico = new MenuClasico(500.);
        MenuVegetariano menuVegetariano = new MenuVegetariano(500.,true,2);
        MenuInfantil menuInfantil = new MenuInfantil(500.,3);
        menuClasico.prepararMenu();
        menuVegetariano.prepararMenu();
        menuInfantil.prepararMenu();
    }
}