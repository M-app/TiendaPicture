/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalleVentas;

import domain.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author Celinda Recinos
 */
public class DetalleVentasDAO implements DetalleVentas {

    @Override
    public DetalleVentasDTO buscarDetalleVentasXCodigo(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<DetalleVentasDTO> buscarDetalleVentas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarDetalleVentas(int cantidad, float subtotal, int idVenta, int codigoProducto) {
        
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call InsertarDetalleventas(?,?,?,?)}");
            sentencia.setInt("cantidad",cantidad);
            sentencia.setFloat("subtotal", subtotal);
            sentencia.setInt("idventa", idVenta);
            sentencia.setInt("codigo", codigoProducto);

            sentencia.execute();
            JOptionPane.showMessageDialog(null,"Datos insertados correctamente en la tabla detalle ventas");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al insertar detalle ventas en la base de datos " + ex.getLocalizedMessage());
        }
    }

    @Override
    public void eliminarDetalleVentas(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
