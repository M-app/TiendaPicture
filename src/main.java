
import domain.Conexion;

public class main {

    public static void main(String[] args) {
        // se conecta a la base de datos e imprime en cosola la respuesta de la conexion
        System.out.println(Conexion.getInstance().conectar());
    }
    
}
