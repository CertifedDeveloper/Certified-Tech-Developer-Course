import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class Test {

    Afiliado afiliadoA;
    Afiliado afiliadoB;
    Empleado empleadoA;
    Empleado empleadoB;
    Pasante pasanteA;
    @BeforeEach
    void doBefore(){
        afiliadoA = new Afiliado("afiliadoA");
        afiliadoB = new Afiliado("afiliadoB");
        empleadoA = new Empleado("empleadoA", 2);
        empleadoB = new Empleado("empleadoB", 1);
        pasanteA = new Pasante("pasanteA");
        empleadoA.agregarAfiliado(afiliadoA);
        empleadoA.agregarAfiliado(afiliadoB);
        empleadoB.agregarAfiliado(afiliadoA);
        empleadoA.vender();
        empleadoB.vender();
        empleadoB.vender();
        afiliadoA.vender();
        afiliadoB.vender();
        afiliadoB.vender();
        pasanteA.vender();
        pasanteA.vender();
        pasanteA.vender();
        pasanteA.vender();
    }
    @org.junit.jupiter.api.Test
    void doTestMostrarCategoria(){
        assertEquals("empleadoA tiene un total de 35, categoriza como buenos", empleadoA.mostrarCategoria());
        assertEquals("empleadoB tiene un total de 25, categoriza como aprendices", empleadoB.mostrarCategoria());
        assertEquals("afiliadoA tiene un total de 15, categoriza como novatos", afiliadoA.mostrarCategoria());
        assertEquals("afiliadoB tiene un total de 30, categoriza como aprendices", afiliadoB.mostrarCategoria());
        assertEquals("pasanteA tiene un total de 20, categoriza como novato", pasanteA.mostrarCategoria());
    }


}