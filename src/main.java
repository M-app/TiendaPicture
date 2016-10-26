
import compras.ComprasDAO;
import domain.Conexion;

public class main {

    public static void main(String[] args) {
        // se conecta a la base de datos e imprime en cosola la respuesta de la conexion
        System.out.println(Conexion.getInstance().conectar());
        
        ComprasDAO dao = new ComprasDAO();
        dao.insertarCompras(300, "25/10/2016", 7654321, 24, "9 avenida zona 18", 1);
        //dao.eliminarCompras(7);
    }
    
}
