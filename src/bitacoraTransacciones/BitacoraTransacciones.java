package bitacoraTransacciones;

import java.util.Collection;

public interface BitacoraTransacciones {
    
    BitacoraDTO buscarBitacoraXCodigo(int codigo);
    Collection<BitacoraDTO> buscarBitacora();
    
    void insertarBitacora(String fecha, String hora, String usuario, String tipoTransaccion);
    
    void eliminarBitacora(int codigo);
}
