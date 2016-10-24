package detalleCompras;

import java.util.Collection;

public interface DetalleCompras {
    void insertarDetalleCompras(int cantidad, float subtotal, 
            int idCompra, int codigoProducto);
    DetalleComprasDTO buscarDetalleComprasXCodigo(int codigo);
    Collection<DetalleComprasDTO> buscarDetalleCompras();
    void eliminarDetalleCompras(int codigo);
}
