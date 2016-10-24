package productos;

import java.util.Collection;

public interface Productos {
    void insertarProducto(String descripcion, float tamanio, String color,
            float capacidad, String marca, String tipo, float precioCosto,
            int existencia, float margenGanancia, float precioPublico);
    
    void actualizarProducto(int codigo, String descripcion, float tamanio,
            String color, float capacidad, String marca, String tipo,
            float precioCosto, int existencia, float margenGanancia,
            float precioPublico);
    
    ProductosDTO buscarProductoXCodigo(int codigo);
    Collection<ProductosDTO> buscarProductos();
    
    void eliminarProducto(int codigo);
}
