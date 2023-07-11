import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProxyTest {
    Usuario usuarioA;
    Usuario usuarioB;
    ServicioDescarga proxy;
    @BeforeEach
    void doBefore(){
        usuarioA = new Usuario(1, Tipo.Premium);
        usuarioB = new Usuario(2, Tipo.Free);
        proxy = new Proxy();
    }
    @Test
    void descargar() {
        assertEquals("Descargando la canción",proxy.descargar(usuarioA));
        assertEquals("No se permite la descarga",proxy.descargar(usuarioB));
    }
}