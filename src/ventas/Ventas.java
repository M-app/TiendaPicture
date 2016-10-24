package ventas;

import java.util.Collection;

public interface Ventas {
    
    Collection<VentasDTO> buscarVentas();
    VentasDTO buscarVentasXCodigo(int codigo);
    void eliminarVentas();
    void insertarVentas(String fecha, float monto, float descuento, int idCliente);
}
