/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gastos;


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
 * @author Joseph
 */
public class GastosDAO implements Gastos {

    @Override
    public GastosDTO buscarGastosXCodigo(int idGasto) {
       final GastosDTO objetoRetorno = new GastosDTO();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarGastos(?)}");
            sentencia.setInt(1, idGasto);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                objetoRetorno.setIdGasto(resultado.getInt("id_gasto"));
                objetoRetorno.setCantidad(resultado.getFloat("cantidad"));
                objetoRetorno.setFecha(resultado.getString("fecha"));
                objetoRetorno.setTipoGasto(resultado.getString("tipoGasto"));
            
            }
            return objetoRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar gastos en la base de datos " + ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Collection<GastosDTO> buscarGastos() {
        final ArrayList<GastosDTO> listaRetorno = new ArrayList();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarGastos}");
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                GastosDTO com = new GastosDTO();
                com.setIdGasto(resultado.getInt("id_gasto"));
                com.setCantidad(resultado.getFloat("cantidad"));
                com.setFecha(resultado.getString("fecha"));
                com.setTipoGasto(resultado.getString("tipoGasto"));
                listaRetorno.add(com);
            }
            return listaRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar gastos en la base de datos " + ex.getLocalizedMessage());
            return null;
        } }

    @Override
    public void insertarGastos(float cantidad, String fecha, String tipoGasto) {
  try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call InsertarGastos(?,?,?,?)}");
            sentencia.setFloat("cantidad",cantidad);
            sentencia.setString("fecha", fecha);
            sentencia.setString("tipoGasto", tipoGasto);
            
            
            sentencia.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al insertar gastos en la base de datos " + ex.getLocalizedMessage());
        }
    }
    
    
}
