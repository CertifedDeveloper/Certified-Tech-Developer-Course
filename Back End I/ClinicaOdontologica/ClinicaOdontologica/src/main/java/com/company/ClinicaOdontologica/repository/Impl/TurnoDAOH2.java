package com.company.ClinicaOdontologica.repository.Impl;

import com.company.ClinicaOdontologica.model.Direccion;
import com.company.ClinicaOdontologica.model.Odontologo;
import com.company.ClinicaOdontologica.model.Paciente;
import com.company.ClinicaOdontologica.repository.IDao;
import com.company.ClinicaOdontologica.model.Turno;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.stereotype.Repository;

import java.awt.desktop.OpenFilesEvent;
import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

@Repository
public class TurnoDAOH2 implements IDao<Turno> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL_CREATE = "jdbc:h2:~/Desktop/ClinicaOdontologica/ClinicaOdontologica/DBClinicaOdontologica;INIT=RUNSCRIPT FROM 'src/main/resources/createTurno.sql'";
    private final static String DB_URL = "jdbc:h2:~/Desktop/ClinicaOdontologica/ClinicaOdontologica/DBClinicaOdontologica;";

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
    public static Connection conB (){
        Connection connection = null;
        try {
            Class.forName(DB_JDBC_DRIVER );
            connection = DriverManager.getConnection(DB_URL);
            logger.info("Conectando a la base de datos");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public Turno guardar(Turno turno) {
        Connection conection = con();
        File log4jfile = new File("src/main/java/com/company/ClinicaOdontologica/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try {
            logger.info("Guardando turno en la base de datos");
            PreparedStatement preparedStatement = conection.prepareStatement("INSERT INTO TURNOS (PACIENTE_ID, ODONTOLOGO_ID, FECHA_HORA)" +
                    "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, turno.getPaciente().getId());
            preparedStatement.setInt(2, turno.getOdontologo().getId());
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
    public Optional<Turno> leer(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Turno turno = null;
        PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();
        OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
        File log4jfile = new File("src/main/java/com/company/ClinicaOdontologica/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            logger.info("Leyendo de la base de datos el turno con id: " + id);
            connection = con();
            preparedStatement = connection.prepareStatement("SELECT * FROM TURNOS WHERE id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idTurno = resultSet.getInt(1);
                int idPaciente = resultSet.getInt(2);
                int idOdontologo = resultSet.getInt(3);
                LocalDate fecha_hora = resultSet.getDate(4).toLocalDate();
                turno = new Turno(idTurno, pacienteDAOH2.leer(idPaciente).orElse(null), odontologoDAOH2.leer(idOdontologo).orElse(null),fecha_hora);
            }
            preparedStatement.close();

        }catch (Exception e){
            logger.error("No se pudo realizar la consulta a la base de datos");
            e.printStackTrace();
        }
        return turno != null ? Optional.of(turno): Optional.empty();
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        File log4jfile = new File("src/main/java/com/company/ClinicaOdontologica/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            logger.info("Eliminando turno de la base de datos");
            connection = conB();
            preparedStatement = connection.prepareStatement("DELETE FROM TURNOS WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();

        }catch (Exception e){
            logger.error("No se pudo eliminar turno a la base de datos");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        PacienteDAOH2 pacienteDAOH2 = new PacienteDAOH2();
        OdontologoDAOH2 odontologoDAOH2 = new OdontologoDAOH2();
        ArrayList<Turno> turnos = new ArrayList<>();
        File log4jfile = new File("src/main/java/com/company/ClinicaOdontologica/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());

        try {
            logger.info("Buscando todos los turnos de la base de datos");
            connection = con();
            preparedStatement = connection.prepareStatement("SELECT * FROM TURNOS;");


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idTurno = resultSet.getInt(1);
                int idPaciente = resultSet.getInt(2);
                int idOdontologo = resultSet.getInt(3);
                LocalDate fecha_hora = resultSet.getDate(4).toLocalDate();
                Turno turno = new Turno(idTurno, pacienteDAOH2.leer(idPaciente).orElse(null), odontologoDAOH2.leer(idOdontologo).orElse(null),fecha_hora);
                turnos.add(turno);
            }
            preparedStatement.close();
        } catch (Exception throwables) {
            logger.error("No se pudo devolver la lista de turnos de la base de datos",throwables);
            throwables.printStackTrace();
        }

        return turnos;
    }

    @Override
    public Turno actualizar(Turno turno) {
        Connection conection = conB();
        File log4jfile = new File("src/main/java/com/company/ClinicaOdontologica/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try {
            logger.info("Actualizando odontologo en la base de datos");
            PreparedStatement preparedStatement = conection.prepareStatement("UPDATE TURNOS SET PACIENTE_ID=?, ODONTOLOGO_ID=?, FECHA_HORA=? WHERE id=?");
            preparedStatement.setInt(1,turno.getPaciente().getId());
            preparedStatement.setInt(2,turno.getPaciente().getId());
            preparedStatement.setInt(3,turno.getOdontologo().getId());
            preparedStatement.setDate(4,Date.valueOf(turno.getFechaHora()));
            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            logger.error("No se pudo actualizar turno en la base de datos",e);
            e.printStackTrace();
        }
        finally{
            try {
                conection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return turno;
    }
}
