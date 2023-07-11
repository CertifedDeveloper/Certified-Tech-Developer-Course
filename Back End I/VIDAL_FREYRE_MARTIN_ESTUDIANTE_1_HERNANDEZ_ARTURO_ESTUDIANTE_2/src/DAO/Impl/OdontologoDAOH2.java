package DAO.Impl;

import DAO.IDao;
import Model.Odontologo;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class OdontologoDAOH2 implements IDao<Odontologo> {
    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/Desktop/VIDAL_FREYRE_MARTIN_ESTUDIANTE_1_HERNANDEZ_ARTURO_ESTUDIANTE_2_B/DBOdontologos;INIT=RUNSCRIPT FROM 'resource/create.sql'";

    private final static Logger logger = Logger.getLogger(OdontologoDAOH2.class);

    public static Connection con (){
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
    public Odontologo registrar(Odontologo odontologo) {
        Connection conection = con();
        File log4jfile = new File("src/log4j.properties");
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
    public ArrayList<Odontologo> listarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Odontologo odontologo = null;
        ArrayList<Odontologo> odontologos = new ArrayList<>();
        File log4jfile = new File("src/log4j.properties");
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
            logger.error("No se pudo devolver la lista de odontologos de la base de datos");
            throwables.printStackTrace();
        }

        return odontologos;
    }
}
