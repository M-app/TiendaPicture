package usuarios;

import java.util.Collection;

public interface Usuarios {
    UsuarioDTO buscarUsuarioXCodigo(int codigo);
    Collection<UsuarioDTO> buscarUsuarios();
    void eliminarUsuario(int codigo);
    void insertarUsuario(String usuario, String pass);
}
