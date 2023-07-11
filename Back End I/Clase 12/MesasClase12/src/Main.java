import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);
    public static void main(String[] args) throws Exception{
        File log4jfile = new File("log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        logger.info("Empezamos el método Main");
        Class.forName("org.h2.Driver");

        //Connection con = DriverManager.getConnection("jdbc:h2:~\\Desktop\\Archivo\\Certified Tech Developer\\Back End I\\Clase 12\\H2Database" + ";DB_CLOSE_DELAY=-1");
        //Connection con = DriverManager.getConnection("jdbc:h2:~/Desktop/Archivo/'Certified Tech Developer'/'Back End I'/'Clase 12'/H2Database" + ";DB_CLOSE_DELAY=-1");
        Connection con = DriverManager.getConnection("jdbc:h2:~/Desktop/H2Database" + ";DB_CLOSE_DELAY=-1");
        Statement stmt = con.createStatement();

        stmt.execute("DROP TABLE IF EXISTS EMPLEADO; CREATE TABLE EMPLEADO (ID INT PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255), PROFESION VARCHAR(255), PUESTO VARCHAR(255))");

        try{
            stmt.execute("INSERT INTO EMPLEADO VALUES(1, 'nombreA', 'apellidoA', 'profesionA', 'puestoA')");
            stmt.execute("INSERT INTO EMPLEADO VALUES(2, 'nombreB', 'apellidoB', 'profesionB', 'puestoB')");
            stmt.execute("INSERT INTO EMPLEADO VALUES(1, 'nombreC', 'apellidoC', 'profesionC', 'puestoC')");
        } catch (Exception e){
            logger.error("Intento de registrar empleado con mismo ID", e);
        }
        ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLEADO");

        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3)+ " " + rs.getString(4)+ " " + rs.getString(5));
        }

        stmt.execute("""
                UPDATE EMPLEADO
                SET PROFESION='profesionC'
                WHERE ID=2""");
        logger.debug("Empleado actualizado por ID=2");

        ResultSet rsB = stmt.executeQuery("SELECT * FROM EMPLEADO");
        while (rsB.next()){
            System.out.println(rsB.getInt(1) + " " + rsB.getString(2) + " " + rsB.getString(3)+ " " + rsB.getString(4)+ " " + rsB.getString(5));
        }


        stmt.execute("DELETE FROM EMPLEADO WHERE ID=2");
        logger.info("Empleado borrado con ID igual a 2");

        ResultSet rsC = stmt.executeQuery("SELECT * FROM EMPLEADO");
        while (rsC.next()){
            System.out.println(rsC.getInt(1) + " " + rsC.getString(2) + " " + rsC.getString(3)+ " " + rsC.getString(4)+ " " + rsC.getString(5));
        }

        stmt.execute("DELETE FROM EMPLEADO WHERE NOMBRE='nombreA'");
        logger.info("Empleado borrado con nombreA");

        ResultSet rsD = stmt.executeQuery("SELECT * FROM EMPLEADO");
        while (rsD.next()){
            System.out.println(rsD.getInt(1) + " " + rsD.getString(2) + " " + rsD.getString(3)+ " " + rsD.getString(4)+ " " + rsD.getString(5));
        }
    }
}