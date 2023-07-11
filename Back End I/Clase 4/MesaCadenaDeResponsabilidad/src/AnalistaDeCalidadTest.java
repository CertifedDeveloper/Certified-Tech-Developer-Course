import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnalistaDeCalidadTest {
    AnalistaDeCalidad analista;
    Articulo articuloA;
    Articulo articuloB;
    Articulo articuloC;
    Articulo articuloD;
    @BeforeEach
    void doBefore(){
        analista = new Lote();
        articuloA = new Articulo("articuloA",1500,1200,"sano");
        articuloB = new Articulo("articuloB",200,1200,"sano");
        articuloC = new Articulo("articuloC",1500,200,"sano");
        articuloD = new Articulo("articuloD",1500,1200,"no aplica");
    }
    @Test
    void validarCalidadDelProducto() {
        assertEquals("aceptado", analista.validarCalidadDelProducto(articuloA));
        assertEquals("rechazado", analista.validarCalidadDelProducto(articuloB));
        assertEquals("rechazado", analista.validarCalidadDelProducto(articuloC));
        assertEquals("rechazado", analista.validarCalidadDelProducto(articuloD));
    }
}