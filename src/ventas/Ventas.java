package ventas;

import java.util.Collection;

public interface Ventas {
    
    Collection<VentasDTO> buscarVentas();
    VentasDTO buscarVentasXCodigo(int idVenta);
    void eliminarVentas(int idVenta);
    void insertarVentas(String fecha, float monto, float descuento, int idCliente);
}
