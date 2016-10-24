package detalleVentas;

import java.util.Collection;

public interface DetalleVentas {
    DetalleVentasDTO buscarDetalleVentasXCodigo(int codigo);
    Collection<DetalleVentasDTO> buscarDetalleVentas();
    void insertarDetalleVentas(int cantidad, float subtotal, int idVenta,
            int codigoProducto);
    
    void eliminarDetalleVentas(int codigo);
}
