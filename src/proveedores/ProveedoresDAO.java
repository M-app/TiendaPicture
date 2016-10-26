package proveedores;
import domain.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

public class ProveedoresDAO implements Proveedores{

    @Override
    public void actualizarProveedores(int codigo, String empresa, String contacto, String telefono, String movil) {
        
    }

    @Override
    public Collection<ProveedoresDTO> buscarProveedores() {
        final ArrayList<ProveedoresDTO> listaRetorno = new ArrayList();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarProveedoresG}");
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                ProveedoresDTO prov = new ProveedoresDTO();
                prov.setCodProveedor(resultado.getInt("codigo_proveedor"));
                prov.setEmpresa(resultado.getString("empresa"));
                prov.setNomContacto(resultado.getString("nomContacto"));
                prov.setTelefonoOficina(resultado.getString("telefonoOficina"));
                prov.setTelefonoMovil(resultado.getString("telefonoMovil"));
                listaRetorno.add(prov);
            }
            return listaRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar proveedores en la base de datos " + ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public ProveedoresDTO buscarProveedoresXCodigo(int codigo) {
        final ProveedoresDTO objetoRetorno = new ProveedoresDTO();
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call BuscarProveedor(?)}");
            sentencia.setInt(1, codigo);
            ResultSet resultado = sentencia.executeQuery();
            while(resultado.next()){
                objetoRetorno.setCodProveedor(resultado.getInt("codigo_proveedor"));
                objetoRetorno.setEmpresa(resultado.getString("empresa"));
                objetoRetorno.setNomContacto(resultado.getString("nomContacto"));
                objetoRetorno.setTelefonoOficina(resultado.getString("telefonoOficina"));
                objetoRetorno.setTelefonoMovil(resultado.getString("telefonoMovil"));
            }
            return objetoRetorno;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al buscar un proveedor en la base de datos " + ex.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public void insertarProveedores(String empresa, String nomContacto, String telefonoOficina, String telefonoMovil) {
        try {
            Connection conn = Conexion.getInstance().getConexion();
            CallableStatement sentencia = conn.prepareCall("{call InsertarProveedores(?,?,?,?)}");
            sentencia.setString("empresa",empresa);
            sentencia.setString("nomContacto", nomContacto);
            sentencia.setString("telefonoOficina", telefonoOficina);
            sentencia.setString("telefonoMovil", telefonoMovil);
            
            sentencia.execute();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al insertar un proveedor en la base de datos " + ex.getLocalizedMessage());
        }
    }
    
}
