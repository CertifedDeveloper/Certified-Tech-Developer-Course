package com.company.dao;

import com.company.entidades.Avion;

import java.io.File;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class AvionDAOH2 implements IDAO<Avion>{
    private static final String DB_JDBC_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/Desktop/DBAvion" + ";DB_CLOSE_DELAY=-1";
    private static final String DB_INSERT = "INSERT INTO Aviones VALUES(?,?,?,?,?)";
    private static final String DB_DELETE = "DELETE FROM Aviones WHERE id=?";
    private static final String DB_SELECT = "SELECT * FROM Aviones WHERE id=?";
    private static final String DB_SELECT_ALL = "SELECT * FROM Aviones";
    private static final Logger logger = Logger.getLogger(AvionDAOH2.class);
    @Override
    public Avion registrar(Avion avion){
        Connection con = null;
        PreparedStatement preparedStatement = null;
        Statement stmt = null;
        File log4jfile = new File("log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            con = getConnection();
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(DB_INSERT);

            preparedStatement.setLong(1,avion.getId());
            preparedStatement.setString(2, avion.getMarca());
            preparedStatement.setString(3, avion.getModelo());
            preparedStatement.setString(4, avion.getMatricula());
            preparedStatement.setDate(5, Date.valueOf(avion.getFechaServicio()));

            preparedStatement.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
            logger.info("Avión registrado en la base de datos");
        } catch (Exception e){
            e.printStackTrace();
            logger.error("Avión no se pudo registrar en la base de datos", e);
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally{
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return avion;
    }

    @Override
    public void eliminar(Long id) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        Statement stmt = null;
        File log4jfile = new File("log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            con = getConnection();
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(DB_DELETE);

            preparedStatement.setLong(1,id);

            preparedStatement.executeUpdate();
            con.commit();
            con.setAutoCommit(true);
            logger.info("Avión eliminado de la base de datos");
        } catch (Exception e){
            e.printStackTrace();
            logger.error("Avión no pudo ser eliminado de la base de datos");
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally{
            try {
                assert con != null;
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Avion buscar(Long id) {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        Avion avion = null;
        File log4jfile = new File("log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            con = getConnection();
            preparedStatement = con.prepareStatement(DB_SELECT);

            preparedStatement.setLong(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Long idAvion = rs.getLong("id");
                String marcaAvion = rs.getString("marca");
                String modeloAvion = rs.getString("modelo");
                String matriculaAvion = rs.getString("matricula");
                LocalDate fechaServicioAvion = rs.getDate("fechaServicio").toLocalDate();

                avion = new Avion();
                avion.setId(idAvion);
                avion.setMarca(marcaAvion);
                avion.setModelo(modeloAvion);
                avion.setMatricula(matriculaAvion);
                avion.setFechaServicio(fechaServicioAvion);
            }
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
            logger.info("La solicitud de búsqueda no pudo ser procesada");
        }
        logger.info("Avión encontrado");
        return avion;
    }

    @Override
    public List<Avion> buscarTodos() {
        Connection con = null;
        PreparedStatement preparedStatement = null;
        List<Avion> aviones =  new ArrayList();
        File log4jfile = new File("log4j.properties");
        PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        try{
            con = getConnection();
            preparedStatement = con.prepareStatement(DB_SELECT_ALL);

            ResultSet rs = preparedStatement.executeQuery();

            while(rs.next()){
                Long idAvion = rs.getLong("id");
                String marcaAvion = rs.getString("marca");
                String modeloAvion = rs.getString("modelo");
                String matriculaAvion = rs.getString("matricula");
                LocalDate fechaServicioAvion = rs.getDate("fechaServicio").toLocalDate();

                Avion avion = new Avion();
                avion.setId(idAvion);
                avion.setMarca(marcaAvion);
                avion.setModelo(modeloAvion);
                avion.setMatricula(matriculaAvion);
                avion.setFechaServicio(fechaServicioAvion);

                aviones.add(avion);
            }
            preparedStatement.close();
        } catch (Exception e){
            e.printStackTrace();
            logger.error("La solicitude de lista de aviones no pudo ser procesada");
        }
        logger.info("Lista de aviones devuelta");
        return aviones;
    }
    public static Connection getConnection() throws Exception {
        Class.forName(DB_JDBC_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL);
        return con;
    }
}
