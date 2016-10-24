package proveedores;

import java.util.Collection;

public interface Proveedores {
    void actualizarProveedores(int codigo, String empresa, String contacto, String telefono, String movil);
    Collection<ProveedoresDTO> buscarProveedores();
    ProveedoresDTO buscarProveedoresXCodigo(int codigo);
    void insertarProveedores(String empresa, String nomContacto, String telefonoOficina, String telefonoMovil);
}
