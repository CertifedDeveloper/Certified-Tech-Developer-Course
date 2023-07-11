import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MenuTest {
    MenuClasico menuClasico;
    MenuVegetariano menuVegetariano;
    MenuInfantil menuInfantil;
    @BeforeEach
    void crearMenues(){
        menuClasico = new MenuClasico(500.);
        menuVegetariano = new MenuVegetariano(500.,true,2);
        menuInfantil = new MenuInfantil(500.,3);
    }
    @Test
    void testArmarMenuClasico() {
        assertEquals("Armado del Menú Clásico (No tiene recargos)", menuClasico.armarMenu());
    }
    @Test
    void testArmarMenuVegetariano() {
        assertEquals("Armado del Menú Vegetariano (Especias: Sí, Cantidad de salsas: 2 )", menuVegetariano.armarMenu());
    }
    @Test
    void testArmarMenuInfantil() {
        assertEquals("Armado del Menú Infantil (Cantidad de Juguetes: 3 )", menuInfantil.armarMenu());
    }
}