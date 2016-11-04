package cajaChica;

import domain.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import javax.swing.JOptionPane;

public class CajaChicaDAO implements CajaChica {
    
    @Override
   public CajaChicaDTO buscarCajaChicaXCodigo(int codigo){
       final CajaChicaDTO cc = new CajaChicaDTO();
       try{
           Connection conn = Conexion.getInstance().getConexion();
           CallableStatement sentencia = conn.prepareCall("{Call busqueda cajachica}");
           sentencia.setInt(1, codigo);
           ResultSet resultado = sentencia.executeQuery();
           while(resultado.next()){
               cc.setIdIngreso(resultado.getInt("idIngreso"));
               cc.setCantidd(resultado.getFloat("Cantidad"));
               cc.setFecha(resultado.getString("fecha"));
           
           }
           return cc;
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error busqueda de cajaChica");
           return null;
       }
   }

    @Override
    public Collection<CajaChicaDTO> buscarCajaChica() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarCajaChica(float cantidad, String fecha, String tipo) {
        try{
        Connection conn = Conexion.getInstance().getConexion();
        CallableStatement sentencia = conn.prepareCall("{call insercion cajaChica}");
        sentencia.setFloat("cantidad",cantidad);
        sentencia.setString("fecha", fecha);
        sentencia.setString("tipo",tipo);
        
        sentencia.execute();}
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al insertar registro en caja chica");
        }
    }

    @Override
    public void eliminarCajaChica(int codigo) {
       try{
           Connection conn = Conexion.getInstance().getConexion();
           CallableStatement sentencia = conn.prepareCall("{call eliminar cajaChica");
           sentencia.setInt(1, codigo);
           sentencia.execute();
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null,"Error al eliminar registro de caja chica");
       }
    }
   /* public void cerrarCaja(){
        try{
            
        }
        catch(Exception e){}
    }*/

    
}
