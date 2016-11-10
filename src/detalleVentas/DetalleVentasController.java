/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package detalleVentas;

/**
 *
 * @author Celinda Recinos
 */
public class DetalleVentasController {
    
    private final DetalleVentas detalleDao;
    
    public DetalleVentasController(){
        detalleDao = new DetalleVentasDAO();
    }
    
    public void insertarDetalleVentas(int cantidad, float subtotal,int idVenta, int codigoProducto){
        detalleDao.insertarDetalleVentas(cantidad, subtotal, idVenta, codigoProducto);
    }
    
}
