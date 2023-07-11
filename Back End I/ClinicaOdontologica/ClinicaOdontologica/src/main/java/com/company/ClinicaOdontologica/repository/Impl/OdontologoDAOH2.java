package com.company.ClinicaOdontologica.repository.Impl;

import com.company.ClinicaOdontologica.repository.IDao;
import com.company.ClinicaOdontologica.model.Odontologo;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

@Repository
@Primary
public class OdontologoDAOH2 implements IDao<Odontologo> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL_CREATE = "jdbc:h2:~/Desktop/ClinicaOdontologica/ClinicaOdontologica/DBClinicaOdontologica;INIT=RUNSCRIPT FROM 'src/main/resources/createOdontologos.sql'";
    private final static String DB_URL = "jdbc:h2:~/Desktop/ClinicaOdontologica/ClinicaOdontologica/DBClinicaOdontologica;";

    private final static Logger logger = Logger.getLogger(OdontologoDAOH2.class);

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
    public Optional<Odontologo> leer(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;
        File log4jfile = new File("src/main/java/com/company/ClinicaOdontologica/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            logger.info("Leyendo de la base de datos el odontologo con id: " + id);
            connection = con();
            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS WHERE id=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                int idOdontologo = resultSet.getInt(1);
                String numeroMatriculaOdontologo = resultSet.getString(2);
                String nombreOdontologo = resultSet.getString(3);
                String apellidoOdontologo = resultSet.getString(4);
                odontologo = new Odontologo(idOdontologo,numeroMatriculaOdontologo,nombreOdontologo,apellidoOdontologo);
            }
            preparedStatement.close();

        }catch (Exception e){
            logger.error("No se pudo realizar la consulta a la base de datos", e);
            e.printStackTrace();
        }
        return odontologo != null ? Optional.of(odontologo):Optional.empty();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection conection = con();
        File log4jfile = new File("src/main/java/com/company/ClinicaOdontologica/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try {
            logger.info("Guardando odontologo en la base de datos");
            PreparedStatement preparedStatement = conection.prepareStatement("INSERT INTO ODONTOLOGOS (NUMERO_MATRICULA, NOMBRE, APELLIDO)" +
                    "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.executeUpdate();

            ResultSet keys = preparedStatement.getGeneratedKeys();
            while (keys.next()) {
                odontologo.setId(keys.getInt(1));
            }
        }
        catch(Exception e){
            logger.error("No se pudo guardar odontologo en la base de datos",e);
            e.printStackTrace();
        }
        finally{
            try {
                conection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        };
        return odontologo;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;
        File log4jfile = new File("src/main/java/com/company/ClinicaOdontologica/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            logger.info("Eliminando odontologo de la base de datos");
            connection = conB();

            preparedStatement= connection.prepareStatement("DELETE FROM ODONTOLOGOS WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            logger.error("No se pudo eliminar paciente de la base de datos", e);
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;
        ArrayList<Odontologo> odontologos = new ArrayList<>();
        File log4jfile = new File("src/main/java/com/company/ClinicaOdontologica/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());

        try {
            logger.info("Buscando todos los odontologos de la base de datos");
            connection = con();
            preparedStatement = connection.prepareStatement("SELECT * FROM ODONTOLOGOS;");


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idOdontologo = resultSet.getInt(1);
                String numeroMatriculaOdontologo = resultSet.getString(2);
                String nombreOdontologo = resultSet.getString(3);
                String apellidoOdontologo = resultSet.getString(4);
                odontologo = new Odontologo(idOdontologo,numeroMatriculaOdontologo,nombreOdontologo,apellidoOdontologo);
                odontologos.add(odontologo);
            }
            preparedStatement.close();
        } catch (Exception throwables) {
            logger.error("No se pudo devolver la lista de odontologos de la base de datos",throwables);
            throwables.printStackTrace();
        }

        return odontologos;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        Connection conection = conB();
        File log4jfile = new File("src/main/java/com/company/ClinicaOdontologica/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try {
            logger.info("Actualizando odontologo en la base de datos");
            PreparedStatement preparedStatement = conection.prepareStatement("UPDATE ODONTOLOGOS SET NUMERO_MATRICULA=?, NOMBRE=?, APELLIDO=? WHERE id=?");
            preparedStatement.setString(1, odontologo.getNumeroMatricula());
            preparedStatement.setString(2, odontologo.getNombre());
            preparedStatement.setString(3, odontologo.getApellido());
            preparedStatement.setInt(4,odontologo.getId());
            preparedStatement.executeUpdate();
        }
        catch(Exception e){
            logger.error("No se pudo actualizar odontologo en la base de datos",e);
            e.printStackTrace();
        }
        finally{
            try {
                conection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return odontologo;
    }
}
