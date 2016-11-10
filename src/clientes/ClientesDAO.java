/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientes;

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
public class ClientesDAO implements Clientes{

    @Override
    public ClientesDTO buscarClientesXCodigo(int codigo) {
        
        final ClientesDTO objetoRetorno = new ClientesDTO();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarClientes(?)}");
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                objetoRetorno.setIdCliente(resultado.getInt("idcliente"));
                objetoRetorno.setNit(resultado.getInt("nit"));
                objetoRetorno.setApellidos(resultado.getString("apellidos"));
                objetoRetorno.setNombre(resultado.getString("nombre"));
                objetoRetorno.setDireccion(resultado.getString("direccion"));
            }
            return objetoRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un proveedor en la base de datos " + ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Collection<ClientesDTO> buscarClientes() {
        
        final ArrayList<ClientesDTO> listaRetorno = new ArrayList();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarClientesG}");
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                ClientesDTO cli = new ClientesDTO();
                cli.setIdCliente(resultado.getInt("idcliente"));
                cli.setNit(resultado.getInt("nit"));
                cli.setApellidos(resultado.getString("apellidos"));
                cli.setNombre(resultado.getString("nombre"));
                cli.setDireccion(resultado.getString("direccion"));
                listaRetorno.add(cli);
            }
            return listaRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar clientes en la base de datos " + ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public void insertarCliente(int nit, String apellidos, String nombre, String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizarCliente(int idCliente, int nit, String apellidos, String nombre, String direccion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarClientes(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
