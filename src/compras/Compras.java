package compras;

import java.util.Collection;

public interface Compras {
    ComprasDTO buscarComprasXCodigo(int codigo);
    Collection<ComprasDTO> buscarCompras();
    
    void insertarCompras(float monto, String fecha, int nit, int noFactura,
            String direccion, int codigoProveedor);
    
    void eliminarCompras(int codigo);
}
