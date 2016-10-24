
import compras.ComprasDAO;
import domain.Conexion;

public class main {

    public static void main(String[] args) {
        // se conecta a la base de datos e imprime en cosola la respuesta de la conexion
        System.out.println(Conexion.getInstance().conectar());
        
        ComprasDAO dao = new ComprasDAO();
        //dao.insertarCompras(200, "24/10/2016", 238874, 23, "5 calle zona 1", 1);
        dao.eliminarCompras(7);
    }
    
}
