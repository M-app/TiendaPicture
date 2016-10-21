package detalleVentas;

public class DetalleVentasDTO {
    private int idDetalle;
    private int cantidad;
    private float subtotal;
    private int idVenta;
    private int codigoProducto;

    public int getIdDetalleVenta() {
        return idDetalle;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalle = idDetalleVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getCodigo() {
        return codigoProducto;
    }

    public void setCodigo(int codigo) {
        this.codigoProducto = codigo;
    }
    
    
}
