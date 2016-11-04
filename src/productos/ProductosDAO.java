/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package productos;

import domain.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;


public class ProductosDAO implements Productos {

    @Override
    public void insertarProducto(String descripcion, float tamanio, String color, float capacidad, String marca, String tipo, float precioCosto, int existencia, float margenGanancia, float precioPublico) {
        
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call InsertarProductos(?,?,?,?,?,?,?,?,?,?)}");
            
                sentencia.setString("descripcion",descripcion);
                sentencia.setFloat("tamaño",tamanio);
                sentencia.setString("color",color);
                sentencia.setFloat("capacidad",capacidad);
                sentencia.setString("marca",marca);
                sentencia.setString("tipo",tipo);
                sentencia.setFloat("pCosto",precioCosto);
                sentencia.setInt("existencia",existencia);
                sentencia.setFloat("mGanancia",margenGanancia);
                sentencia.setFloat("pPublico",precioPublico);
            
            sentencia.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al insertar producto en la base de datos " + ex.getLocalizedMessage());
        }
    }

    @Override
    public void actualizarProducto(int codigo, String descripcion, float tamanio, String color, float capacidad, String marca, String tipo, float precioCosto, int existencia, float margenGanancia, float precioPublico) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ProductosDTO buscarProductoXCodigo(int codigo) {
    
        final ProductosDTO objetoRetorno = new ProductosDTO();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarProducto(?)}");
            sentencia.setInt(1,codigo);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                objetoRetorno.setCodigo(resultado.getInt("codigo"));
                objetoRetorno.setDescripcion(resultado.getString("descripcion"));
                objetoRetorno.setTamanio(resultado.getFloat("tamaño"));
                objetoRetorno.setColor(resultado.getString("color"));
                objetoRetorno.setCapacidad(resultado.getFloat("capacidad"));
                objetoRetorno.setMarca(resultado.getString("marca"));
                objetoRetorno.setTipo(resultado.getString("tipo"));
                objetoRetorno.setPrecioCosto(resultado.getFloat("pCosto"));
                objetoRetorno.setExistencia(resultado.getInt("existencia"));
                objetoRetorno.setMargenGanancia(resultado.getFloat("mGanancia"));
                objetoRetorno.setPrecioPublico(resultado.getFloat("pPublico"));
            }
            return objetoRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar productos en la base de datos " + ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Collection<ProductosDTO> buscarProductos() {
        final ArrayList<ProductosDTO> listaRetorno = new ArrayList();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarProductoG}");
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                ProductosDTO com = new ProductosDTO();
                com.setCodigo(resultado.getInt("codigo"));
                com.setDescripcion(resultado.getString("descripcion"));
                com.setTamanio(resultado.getFloat("tamaño"));
                com.setColor(resultado.getString("color"));
                com.setCapacidad(resultado.getFloat("capacidad"));
                com.setMarca(resultado.getString("marca"));
                com.setTipo(resultado.getString("tipo"));
                com.setPrecioCosto(resultado.getFloat("pCosto"));
                com.setExistencia(resultado.getInt("existencia"));
                com.setMargenGanancia(resultado.getFloat("mGanancia"));
                com.setPrecioPublico(resultado.getFloat("pPublico"));
                listaRetorno.add(com);
            }
            return listaRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar productos en la base de datos " + ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public void eliminarProducto(int codigo) {
        
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call EliminarProductos(?)}");
            sentencia.setInt(1,codigo);
            sentencia.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al eliminar productos en la base de datos " + ex.getLocalizedMessage());
        }
    }
    
}
