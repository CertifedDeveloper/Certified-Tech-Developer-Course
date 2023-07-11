import DAO.Impl.OdontologoDAOH2;
import Model.Odontologo;
import Service.OdontologoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OdontologoServiceTest {
    Odontologo odontologo1;
    Odontologo odontologo2;
    Odontologo odontologo3;
    Odontologo odontologo4;
    OdontologoService odontologoService;
    @BeforeEach
    void doBefore(){
        odontologo1 = new Odontologo("AAA","Mike","Power");
        odontologo2 = new Odontologo("BBB","Jack","Sparrow");
        odontologo3 = new Odontologo("CCC","Peter","Parker");
        odontologo4 = new Odontologo("DDD","MikeB","PowerB");
        odontologoService = new OdontologoService(new OdontologoDAOH2());
    }

    @Test
    void listarTodos() {
        odontologoService.registrar(odontologo1);
        odontologoService.registrar(odontologo2);
        odontologoService.registrar(odontologo3);
        assertEquals("[Odontologo{id=1, numeroMatricula='AAA', nombre='Mike', apellido='Power'}, Odontologo{id=2, numeroMatricula='BBB', nombre='Jack', apellido='Sparrow'}, Odontologo{id=3, numeroMatricula='CCC', nombre='Peter', apellido='Parker'}]",odontologoService.listarTodos().toString());
    }
    @Test
    void registrar() {
        assertEquals("Odontologo{id=4, numeroMatricula='DDD', nombre='MikeB', apellido='PowerB'}", odontologoService.registrar(odontologo4).toString());
    }
}