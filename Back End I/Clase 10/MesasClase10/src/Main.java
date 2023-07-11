import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        File log4jfile = new File("MesasClase10/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        logger.info("Empezamos el método Main");
        //List<Integer> listaEnteros = Arrays.asList(1,2,3,4,5,6,7,8,9,10,10);
        //List<Integer> listaEnteros = Arrays.asList(1,2,3,4,5,5);
        List<Integer> listaEnteros = new ArrayList<>();
        Integer suma = 0;
        Integer promedio;
        if (listaEnteros.size() > 5){
            logger.info("La longitud de la lista es mayor a 5");
        }
        if (listaEnteros.size() > 10){
            logger.info("La longitud de la lista es mayor a 10");
        }
        for (Integer entero : listaEnteros){
            suma += entero;
        }
        if (listaEnteros.size() == 0){
            logger.error("La lista es igual a cero");
        } else {
            promedio = suma / listaEnteros.size();
            logger.info("Calculando el promedio");
            System.out.println("El promedio es: " + promedio);
        }
    }
}