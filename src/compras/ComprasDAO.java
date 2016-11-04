package compras;

import domain.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

public class ComprasDAO implements Compras {

    @Override
    public ComprasDTO buscarComprasXCodigo(int codigo) {
        final ComprasDTO objetoRetorno = new ComprasDTO();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarGastos(?)}");
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                objetoRetorno.setIdCompra(resultado.getInt("id_compra"));
                objetoRetorno.setMonto(resultado.getFloat("monto"));
                objetoRetorno.setFecha(resultado.getString("fecha"));
                objetoRetorno.setNit(resultado.getInt("nit"));
                objetoRetorno.setNoFactura(resultado.getInt("no_factura"));
                objetoRetorno.setDireccion(resultado.getString("direccion"));
                objetoRetorno.setCodigoProveedor(resultado.getInt("codigo_proveedor"));
            }
            return objetoRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar compras en la base de datos " + ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Collection<ComprasDTO> buscarCompras() {
        final ArrayList<ComprasDTO> listaRetorno = new ArrayList();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarComprasG}");
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                ComprasDTO com = new ComprasDTO();
                com.setIdCompra(resultado.getInt("id_compra"));
                com.setMonto(resultado.getFloat("monto"));
                com.setFecha(resultado.getString("fecha"));
                com.setNit(resultado.getInt("nit"));
                com.setNoFactura(resultado.getInt("no_factura"));
                com.setDireccion(resultado.getString("direccion"));
                com.setCodigoProveedor(resultado.getInt("codigo_proveedor"));
                listaRetorno.add(com);
            }
            return listaRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar compras en la base de datos " + ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public void insertarCompras(float monto, String fecha, int nit, int noFactura, String direccion, int codigoProveedor) {
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call InsertarCompras(?,?,?,?,?,?)}");
            sentencia.setFloat("monto",monto);
            sentencia.setString("fecha", fecha);
            sentencia.setInt("nit", nit);
            sentencia.setInt("no_factura", noFactura);
            sentencia.setString("direccion", direccion);
            sentencia.setInt("codigo_proveedor", codigoProveedor);
            
            sentencia.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al insertar compras en la base de datos " + ex.getLocalizedMessage());
        }
    }

    @Override
    public void eliminarCompras(int codigo) {
         try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call EliminarCompras(?)}");
            sentencia.setInt(1, codigo);
            sentencia.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al insertar compras en la base de datos " + ex.getLocalizedMessage());
        }
    }
}
