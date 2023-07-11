import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerieProxyTest {
    ISerie proxy;
    String expectedMessageA;
    String expectedMessageB;
    String actualMessage;
    @BeforeEach
    void doBefore(){
        proxy = new SerieProxy();
        ((SerieProxy)proxy).agregarSerie("peliculaA");
        ((SerieProxy)proxy).agregarSerie("peliculaB");
        ((SerieProxy)proxy).agregarSerie("peliculaC");

        expectedMessageB = "Ha superado la cantidad de reproducciones permitidas";
    }

    @Test
    void getPeliculaA() {

        expectedMessageA= "www.peliculaA";

        try{
            assertEquals(expectedMessageA,proxy.getPelicula("peliculaA"));
        }
        catch(SerieNoHabilitadaException e){
            actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessageB));
        }
    }
    @Test
    void getPeliculaB() {
        expectedMessageA= "www.peliculaB";

        try{
            assertEquals(expectedMessageA,proxy.getPelicula("peliculaB"));
            assertEquals(expectedMessageA,proxy.getPelicula("peliculaB"));
            assertEquals(expectedMessageA,proxy.getPelicula("peliculaB"));
        }
        catch(SerieNoHabilitadaException e){
            actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessageB));
        }
    }
    @Test
    void getPeliculaC() {
        expectedMessageA= "www.peliculaC";

        try{
            assertEquals(expectedMessageA,proxy.getPelicula("peliculaC"));
            assertEquals(expectedMessageA,proxy.getPelicula("peliculaC"));
            assertEquals(expectedMessageA,proxy.getPelicula("peliculaC"));
            assertEquals(expectedMessageA,proxy.getPelicula("peliculaC"));
            assertEquals(expectedMessageA,proxy.getPelicula("peliculaC"));
            assertEquals(expectedMessageA,proxy.getPelicula("peliculaC"));
        }
        catch(SerieNoHabilitadaException e){
            actualMessage = e.getMessage();
            assertTrue(actualMessage.contains(expectedMessageB));
        }
    }
}