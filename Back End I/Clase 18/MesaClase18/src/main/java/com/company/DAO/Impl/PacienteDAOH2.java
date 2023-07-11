package com.company.DAO.Impl;

import com.company.DAO.IDao;
import com.company.Model.Direccion;
import com.company.Model.Paciente;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.security.UnresolvedPermission;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class PacienteDAOH2 implements IDao<Paciente> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL_CREATE = "jdbc:h2:~/Desktop/MesaClase18/DBClinicaDental;INIT=RUNSCRIPT FROM 'src/main/resources/createPacientes.sql'";
    private final static String DB_URL = "jdbc:h2:~/Desktop/MesaClase18/DBClinicaDental;";
    private final static Logger logger = Logger.getLogger(PacienteDAOH2.class);

    public static Connection con(){
        Connection c = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            c = DriverManager.getConnection(DB_URL_CREATE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static Connection conB(){
        Connection c = null;
        try {
            Class.forName(DB_JDBC_DRIVER );
            c = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public Paciente leer(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;
        Direccion domicilio = null;
        DireccionDAOH2 d = new DireccionDAOH2();
        File log4jfile = new File("src/main/java/com/company/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            logger.info("Leyendo de la base de datos el paciente con id: " + id);
            connection = conB();
            preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTES WHERE id=?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int idPaciente = rs.getInt(1);
                String nombrePaciente = rs.getString(2);
                String apellidoPaciente = rs.getString(3);
                String DNIPaciente = rs.getString(4);
                LocalDate fechaIngresoPaciente = rs.getDate(5).toLocalDate();
                domicilio = d.leer(rs.getInt(6));
                paciente = new Paciente(idPaciente, nombrePaciente,apellidoPaciente,DNIPaciente, fechaIngresoPaciente, domicilio);
            }
            preparedStatement.close();

        }catch (Exception e){
            logger.error("No se pudo realizar la consulta a la base de datos");
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public Paciente guardar(Paciente unPaciente) {

        // guardo en la tabla Direcciones la direccion del Paciente
        DireccionDAOH2 d = new DireccionDAOH2();
        Direccion elDomi = d.guardar(unPaciente.getDomicilio());

        // vuelvo a poner la direccion con el id de la tabla en el paciente
        unPaciente.setDomicilio(elDomi);

        Connection conection = con();
        File log4jfile = new File("src/main/java/com/company/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try {
            logger.info("Guardando paciente en la base de datos");
            PreparedStatement pst = conection.prepareStatement("INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHAINGRESO, ID_DOMICILIO) " +
                    "VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, unPaciente.getNombre());
            pst.setString(2, unPaciente.getApellido());
            pst.setString(3, unPaciente.getDni());
            pst.setDate(4, Date.valueOf(unPaciente.getFecha_ingreso()));
            pst.setInt(5, unPaciente.getDomicilio().getId());
            pst.executeUpdate();

            ResultSet keys = pst.getGeneratedKeys();
            while (keys.next()) {
                unPaciente.setId(keys.getInt(1));
            }
        }
        catch(Exception e){
            logger.error("No se pudo guardar paciente en la base de datos",e);
            e.printStackTrace();
        }
        finally{
            try {
                conection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        };
        return unPaciente;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatementA = null;
        PreparedStatement preparedStatementB = null;
        Paciente paciente = null;
        int domicilioId;
        DireccionDAOH2 d = new DireccionDAOH2();
        File log4jfile = new File("src/main/java/com/company/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            logger.info("Eliminando paciente de la base de datos");
            connection = conB();
            preparedStatementB = connection.prepareStatement("SELECT * FROM PACIENTES WHERE id=?");
            preparedStatementB.setInt(1,id);
            ResultSet rs = preparedStatementB.executeQuery();
            while(rs.next()){
                domicilioId = rs.getInt(6);
                d.eliminar(domicilioId);
            }
            preparedStatementA = connection.prepareStatement("DELETE FROM PACIENTES WHERE id=?");
            preparedStatementA.setInt(1,id);
            preparedStatementA.executeUpdate();
            preparedStatementB.close();
            preparedStatementA.close();
        }catch (Exception e){
            logger.error("No se pudo eliminar paciente de la base de datos");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Paciente> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;
        Direccion domicilio = null;
        ArrayList<Paciente> pacientes = new ArrayList<>();
        DireccionDAOH2 d = new DireccionDAOH2();
        File log4jfile = new File("src/main/java/com/company/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try {
            logger.info("Buscando todos los pacientes de la base de datos");
            //1 Levantar el driver y Conectarnos
            connection = conB();

            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTES;");

            //3 Ejecutar una sentencia SQL
            ResultSet rs = preparedStatement.executeQuery();


            //4 Obtener resultados
            while (rs.next()) {
                int idPaciente = rs.getInt(1);
                String nombrePaciente = rs.getString(2);
                String apellidoPaciente = rs.getString(3);
                String DNIPaciente = rs.getString(4);
                LocalDate fechaIngresoPaciente = rs.getDate(5).toLocalDate();
                domicilio = d.leer(rs.getInt(6));
                paciente = new Paciente(idPaciente, nombrePaciente,apellidoPaciente,DNIPaciente, fechaIngresoPaciente, domicilio);
                pacientes.add(paciente);
            }
            preparedStatement.close();
        } catch (Exception throwables) {
            logger.error("No se pudo devolver la lista de pacientes de la base de datos");
            throwables.printStackTrace();
        }

        return pacientes;
    }
}
