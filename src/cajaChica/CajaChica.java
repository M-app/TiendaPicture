package cajaChica;

import java.util.Collection;

public interface CajaChica {
    CajaChicaDTO buscarCajaChicaXCodigo(int codigo);
    Collection<CajaChicaDTO> buscarCajaChica();
    
    void insertarCajaChica(float cantidad, String fecha, String tipo);
    
    void eliminarCajaChica(int codigo);
}
