import DAO.Impl.OdontologoDAOArray;
import DAO.Impl.OdontologoDAOH2;
import Model.Odontologo;
import Service.OdontologoService;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class Main {
    private final static Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        File log4jfile = new File("src/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        Odontologo odontologo1 = new Odontologo("AAA","Mike","Power");
        Odontologo odontologo2 = new Odontologo("BBB","Jack","Sparrow");
        Odontologo odontologo3 = new Odontologo("CCC","Peter","Parker");
        Odontologo odontologoArray = new Odontologo("DDD","nombreArray","apellidoArray");
        Odontologo odontologoArrayB = new Odontologo("EEE","nombreArrayB","apellidoArrayB");

        OdontologoService odontologoService = new OdontologoService(new OdontologoDAOH2());
        OdontologoService odontologoServiceB = new OdontologoService(new OdontologoDAOArray());

        odontologoService.registrar(odontologo1);
        odontologoService.registrar(odontologo2);
        odontologoService.registrar(odontologo3);

        odontologoServiceB.registrar(odontologoArray);
        odontologoServiceB.registrar(odontologoArrayB);

        logger.info("Registrando odontologo: "+ odontologoService.registrar(odontologo1));
        logger.info("Registrando odontologo: "+ odontologoService.registrar(odontologo2));
        logger.info("Registrando odontologo: "+ odontologoService.registrar(odontologo3));
        logger.info("Listando todos los odontologos: " + odontologoService.listarTodos());

        logger.info("Listando todos los odontologos Array: " + odontologoServiceB.listarTodos());
    }
}
