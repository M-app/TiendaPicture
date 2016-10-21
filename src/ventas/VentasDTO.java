package ventas;

public class VentasDTO {
    
    private int idVenta;
    private String fecha;
    private float monto;
    private float descuento;
    private float idCliente;

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public float getDescuento() {
        return descuento;
    }

    public void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(float idCliente) {
        this.idCliente = idCliente;
    }
    
    
}
