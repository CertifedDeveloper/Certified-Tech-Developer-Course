import java.sql.*;
import java.sql.DriverManager;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception{
        Class.forName("org.h2.Driver");

        Connection con = DriverManager.getConnection("jdbc:h2:" + "C:\\Users\\User\\Desktop\\Archivo\\Certified Tech Developer\\Back End I\\Clase 11\\H2Database" + ";DB_CLOSE_DELAY=-1" + ";FILE_LOCK=NO", "user","user");
        Statement stmt = con.createStatement();

        stmt.execute("DROP TABLE IF EXISTS FIGURASCLASE11; CREATE TABLE FIGURASCLASE11 (ID INT PRIMARY KEY, FIGURA VARCHAR(255), COLOR VARCHAR(255))");

        stmt.execute("INSERT INTO FIGURASCLASE11 VALUES(1, 'Circulo', 'Rojo')");
        stmt.execute("INSERT INTO FIGURASCLASE11 VALUES(2, 'Circulo', 'Verde')");
        stmt.execute("INSERT INTO FIGURASCLASE11 VALUES(3, 'Cuadrado', 'Azul')");
        stmt.execute("INSERT INTO FIGURASCLASE11 VALUES(4, 'Cuadrado', 'Amarillo')");
        stmt.execute("INSERT INTO FIGURASCLASE11 VALUES(5, 'Cuadrado', 'Verde')");
        stmt.execute("INSERT INTO FIGURASCLASE11 VALUES(6, 'Circulo', 'Rojo')");

        ResultSet rs = stmt.executeQuery("SELECT * FROM FIGURASCLASE11 WHERE FIGURA = 'Circulo' AND COLOR = 'Rojo'");

        while (rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
        }
    }
}