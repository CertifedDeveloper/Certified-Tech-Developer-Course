package com.company.DAO.Impl;

import com.company.DAO.IDao;
import com.company.Model.Turno;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class TurnoDAOH2 implements IDao<Turno> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL_CREATE = "jdbc:h2:~/Desktop/MesaClase24/DBClinicaDental;INIT=RUNSCRIPT FROM 'src/main/resources/createTurno.sql'";
    private final static String DB_URL = "jdbc:h2:~/Desktop/MesaClase24/DBClinicaDental;";

    private final static Logger logger = Logger.getLogger(TurnoDAOH2.class);

    public static Connection con (){
        Connection connection = null;
        try {
            Class.forName(DB_JDBC_DRIVER );
            connection = DriverManager.getConnection(DB_URL_CREATE);
            logger.info("Conectando a la base de datos");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Turno guardar(Turno turno) {
        Connection conection = con();
        File log4jfile = new File("src/main/java/com/company/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try {
            logger.info("Guardando turno en la base de datos");
            PreparedStatement preparedStatement = conection.prepareStatement("INSERT INTO TURNOS (PACIENTE_ID, ODONTOLOGO_ID, FECHA_HORA)" +
                    "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, turno.getPacienteId());
            preparedStatement.setInt(2, turno.getOdontologoId());
            preparedStatement.setDate(3, Date.valueOf(turno.getFechaHora()));
            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            while (keys.next()) {
                turno.setTurnoId(keys.getInt(1));
            }
        }
        catch(Exception e){
            logger.error("No se pudo guardar turno en la base de datos",e);
            e.printStackTrace();
        }
        finally{
            try {
                conection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        };
        return turno;
    }


    @Override
    public Turno leer(int id) {
        return null;
    }

    @Override
    public void eliminar(int id) {

    }

    @Override
    public ArrayList buscarTodos() {
        return null;
    }
}
