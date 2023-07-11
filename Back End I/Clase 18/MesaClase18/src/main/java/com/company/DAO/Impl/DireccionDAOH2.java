package com.company.DAO.Impl;

import com.company.DAO.IDao;
import com.company.Model.Direccion;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;


public class DireccionDAOH2 implements IDao<Direccion> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/Desktop/MesaClase18/DBClinicaDental;";
    private final static String DB_URL_CREATE = "jdbc:h2:~/Desktop/MesaClase18/DBClinicaDental;INIT=RUNSCRIPT FROM 'src/main/resources/createDirecciones.sql'";

    private final static org.apache.log4j.Logger logger = Logger.getLogger(DireccionDAOH2.class);
    @Override
    public Direccion leer(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Direccion domicilio = null;
        DireccionDAOH2 d = new DireccionDAOH2();
        File log4jfile = new File("src/main/java/com/company/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            logger.info("Leyendo de la base de datos el domicilio con id: " + id);
            connection = conB();
            preparedStatement = connection.prepareStatement("SELECT * FROM DIRECCIONES WHERE id=?");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                int idDomicilio = rs.getInt(1);
                String calleDomicilio = rs.getString(2);
                int numeroDomicilio = rs.getInt(3);
                String localidadDomicilio = rs.getString(4);
                String provinciaDomicilio = rs.getString(5);
                domicilio = new Direccion(idDomicilio, calleDomicilio, numeroDomicilio,localidadDomicilio,provinciaDomicilio);
            }

        }catch (Exception e){
            logger.error("No se pudo realizar la consulta a la base de datos");
            e.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public Direccion guardar(Direccion unaDireccion) {
        Connection conection = con();
        File log4jfile = new File("src/main/java/com/company/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try {
            logger.info("Guardando dirección en la base de datos");
            PreparedStatement pst = conection.prepareStatement("INSERT INTO DIRECCIONES (CALLE, NUMERO, LOCALIDAD, PROVINCIA) " +
                    "VALUES (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, unaDireccion.getCalle());
            pst.setInt(2, unaDireccion.getNumero());
            pst.setString(3, unaDireccion.getLocalidad());
            pst.setString(4, unaDireccion.getProvincia());
            pst.executeUpdate();

            ResultSet keys = pst.getGeneratedKeys();
            while (keys.next()) {
                unaDireccion.setId(keys.getInt(1));
            }
        }
        catch (Exception e){
            logger.error("No se pudo guardar domicilio en la base de datos",e);
            e.printStackTrace();
        }
        finally{
            try {
                conection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        };
        return unaDireccion;
    }

    @Override
    public void eliminar(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        File log4jfile = new File("src/main/java/com/company/log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            logger.info("Eliminando domicilio de la base de datos");
            connection = conB();
            preparedStatement = connection.prepareStatement("DELETE FROM DIRECCIONES WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            logger.error("No se pudo eliminar domicilio de la base de datos");
            e.printStackTrace();
        }
    }

    public static Connection con (){
        Connection c = null;
        try {
            Class.forName(DB_JDBC_DRIVER );
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
    public ArrayList<Direccion> buscarTodos() {
        return null;
    }
}