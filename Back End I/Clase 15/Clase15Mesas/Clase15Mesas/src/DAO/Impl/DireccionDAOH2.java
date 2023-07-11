package DAO.Impl;

import DAO.IDao;
import Model.Direccion;
import Model.Paciente;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;


public class DireccionDAOH2 implements IDao<Direccion> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    //con la instruccion INIT=RUNSCRIPT cuando se conecta a la base ejecuta el script de sql que esta en dicho archivo
    //private final static String DB_URL = "jdbc:h2:~/DBPacientes;INIT=RUNSCRIPT FROM 'create.sql'";
     private final static String DB_URL = "jdbc:h2:c:/ARCHIVOS/DBPacientes;INIT=RUNSCRIPT FROM 'resource/create.sql'";
    private final static String DB_USER ="RICK";
    private final static String DB_PASSWORD = "";
    @Override
    public Direccion leer(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Direccion domicilio = null;
        DireccionDAOH2 d = new DireccionDAOH2();
        try{
            connection = con();
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
            e.printStackTrace();
        }
        return domicilio;
    }

    @Override
    public Direccion guardar(Direccion unaDireccion) {
        Connection conection = con();
        try {
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
        try{
            connection = con();
            preparedStatement = connection.prepareStatement("DELETE FROM DIRECCIONES WHERE id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static Connection con (){
        Connection c = null;
        try {
            Class.forName(DB_JDBC_DRIVER );
            c = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
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
