package domain;

import java.sql.Connection;
import java.sql.DriverManager;
 
public class Conexion {
    
    Connection conn;
    
    private static class SingletonHolder{
        public static final Conexion INSTANCE = new Conexion();
    }
    
    public static Conexion getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public String conectar()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://104.236.147.241/pictur","alumno","umgAlumno");
            return "Se ha conectado a la base de datos";
        }
        catch (Exception e)
        {
            return "Ocurrió un error al conectar con la base de datos " + e.getLocalizedMessage();
        }
    }
    
    public Connection getConexion()
    {
        return conn;
    }

    /*
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
    }*/
    
    
    
}

