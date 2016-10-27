/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import compras.ComprasDTO;
import domain.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author Celinda Recinos
 */
public class VentasDAO implements Ventas{

    @Override
    public Collection<VentasDTO> buscarVentas() {
         final ArrayList<VentasDTO> listaRetorno = new ArrayList();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarVentasG}");
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                VentasDTO com = new VentasDTO();
                com.setIdVenta(resultado.getInt("idVenta"));
                com.setFecha(resultado.getString("fecha"));
                com.setMonto(resultado.getFloat("monto"));
                com.setDescuento(resultado.getFloat("descuento"));
                com.setIdCliente(resultado.getInt("idCliente"));
                listaRetorno.add(com);
            }
            return listaRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar ventas en la base de datos " + ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public VentasDTO buscarVentasXCodigo(int idVenta) {
        final VentasDTO objetoRetorno = new VentasDTO();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarVentas(?)}");
            sentencia.setInt(1,idVenta);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                objetoRetorno.setIdVenta(resultado.getInt("idVenta"));
                objetoRetorno.setFecha(resultado.getString("fecha"));
                objetoRetorno.setMonto(resultado.getFloat("monto"));
                objetoRetorno.setDescuento(resultado.getFloat("descuento"));
                objetoRetorno.setIdCliente(resultado.getInt("codigo_proveedor"));
            }
            return objetoRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar venta en la base de datos " + ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public void eliminarVentas(int idVenta) {
        
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call EliminarVentas(?)}");
            sentencia.setInt(1,idVenta);
            sentencia.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al eliminar venta en la base de datos " + ex.getLocalizedMessage());
        }
    }

    @Override
    public void insertarVentas(String fecha, float monto, float descuento, int idCliente) {
        
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call InsertarVentas(?,?,?,?)}");
            
            sentencia.setString("fecha", fecha);
            sentencia.setFloat("monto",monto);
            sentencia.setFloat("descuento",descuento);
            sentencia.setInt("idCliente",idCliente);
            
            sentencia.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al insertar venta en la base de datos " + ex.getLocalizedMessage());
        }
    }
    
}
