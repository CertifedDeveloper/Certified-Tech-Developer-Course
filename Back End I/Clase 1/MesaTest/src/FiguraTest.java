import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FiguraTest {
    @Test
    void test(){
        Figura circulo = new Figura(2, "circulo");
        Figura cuadrado = new Figura(3, "cuadrado");
        assertEquals(2*2*Math.PI, circulo.calcularArea());
        assertEquals(3*3, cuadrado.calcularArea());
    }
}