import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrecioVentaTest {
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
    void testCalcularPrecioMenuClasico() {
        assertEquals(500.0, menuClasico.calcularPrecioVenta());
    }
    @Test
    void testCalcularPrecioMenuVegetariano() {
        assertEquals(509.0, menuVegetariano.calcularPrecioVenta());
    }
    @Test
    void testCalcularPrecioMenuInfantil() {
        assertEquals(509.0, menuInfantil.calcularPrecioVenta());
    }
}
