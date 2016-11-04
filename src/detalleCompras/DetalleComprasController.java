package detalleCompras;


public class DetalleComprasController {
    
    private final DetalleCompras detalleDao;
    
    public DetalleComprasController(){
        detalleDao = new DetalleComprasDAO();
    }
    
    public void insertarDetalleCompras(int cantidad, float subtotal,int idCompra, int codigoProducto){
        detalleDao.insertarDetalleCompras(cantidad, subtotal, idCompra, codigoProducto);
    }
}
