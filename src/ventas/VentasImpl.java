/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import java.util.Collection;

/**
 *
 * @author user
 */
public class VentasImpl implements Ventas {

    @Override
    public Collection<VentasDTO> buscarVentas() {
        return null;
    }

    @Override
    public VentasDTO buscarVentasXCodigo(int codigo) {
        return null;
    }

    @Override
    public void eliminarVentas() {
       
    }

    @Override
    public void insertarVentas(String fecha, float monto, float descuento, int idCliente) {
        
    }
    
}
