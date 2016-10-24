package clientes;

import java.util.Collection;

public interface Clientes {
    ClientesDTO buscarClientesXCodigo(int codigo);
    Collection<ClientesDTO> buscarClientes();
    
    void insertarCliente(int nit, String apellidos, String nombre, String direccion);
    void actualizarCliente(int idCliente,int nit, String apellidos, String nombre, String direccion);
    
    void eliminarClientes(int codigo);
}
