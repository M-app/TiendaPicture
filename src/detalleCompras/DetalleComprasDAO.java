package detalleCompras;

import domain.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import javax.swing.JOptionPane;

public class DetalleComprasDAO implements DetalleCompras {

    @Override
    public void insertarDetalleCompras(int cantidad, float subtotal, int idCompra, int codigoProducto) {
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call InsertarDetallecompras(?,?,?,?)}");
            sentencia.setInt("cantidad",cantidad);
            sentencia.setFloat("subtotal", subtotal);
            sentencia.setInt("id_compra", idCompra);
            sentencia.setInt("codigo", codigoProducto);

            sentencia.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al insertar detalle compras en la base de datos " + ex.getLocalizedMessage());
        }
    }

    @Override
    public DetalleComprasDTO buscarDetalleComprasXCodigo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<DetalleComprasDTO> buscarDetalleCompras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarDetalleCompras(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
