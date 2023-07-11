import java.sql.*;

public class Main {
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String DB_URL = "jdbc:h2:~/Desktop/dbOdontologos" + ";DB_CLOSE_DELAY=-1";
    private static final String SQL_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS; CREATE TABLE ODONTOLOGOS (ID BIGINT PRIMARY KEY, NOMBRE VARCHAR(255), APELLIDO VARCHAR(255), MATRICULA VARCHAR(255))";
    private static final String SQL_INSERT = "INSERT INTO ODONTOLOGOS VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE ODONTOLOGOS SET MATRICULA=? WHERE ID=?";
    private static final String SQL_SELECT = "SELECT * FROM ODONTOLOGOS";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;
        try{
            connection = getConnection();
            statement = connection.createStatement();
            statement.execute(SQL_CREATE);
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            connection = getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(SQL_INSERT);
            preparedStatement.setLong(1,1L);
            preparedStatement.setString(2,"nombreA");
            preparedStatement.setString(3,"apellidoA");
            preparedStatement.setString(4,"123ABC");
            preparedStatement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception e){
            e.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT);
            while(rs.next()){
                System.out.println("(ID: " + rs.getLong("ID") + ", NOMBRE: " + rs.getString("NOMBRE") + ", APELLIDO: " + rs.getString("APELLIDO") + ", MATRICULA: " + rs.getString("MATRICULA") + ")");
            }
        } catch (Exception e){
            e.printStackTrace();

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            connection = getConnection();
            connection.setAutoCommit(false);

            preparedStatement = connection.prepareStatement(SQL_UPDATE);
            preparedStatement.setString(1,"1234ABCD");
            preparedStatement.setLong(2,1L);
            preparedStatement.executeUpdate();

            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception e){
            e.printStackTrace();
            try {
                if (connection != null) {
                    connection.rollback();
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        try{
            connection = getConnection();
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL_SELECT);
            while(rs.next()){
                System.out.println("(ID: " + rs.getLong("ID") + ", NOMBRE: " + rs.getString("NOMBRE") + ", APELLIDO: " + rs.getString("APELLIDO") + ", MATRICULA: " + rs.getString("MATRICULA") + ")");
            }
        } catch (Exception e){
            e.printStackTrace();

        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static Connection getConnection() throws Exception{
        Class.forName(DB_DRIVER);
        Connection con = DriverManager.getConnection(DB_URL);
        return con;
    }
}