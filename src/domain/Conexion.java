package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
 
public class Conexion {

    public static void main(String[] args) {
 
       
        Connection conn = null;
        try {
            String url = "jdbc:mysql://104.236.147.241/pictur";
            String usuario = "alumno";
            String password = "umgAlumno";
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                System.out.println("Connected to the database test1");
            }
 
        } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
        }
    }
    
    
    
}

