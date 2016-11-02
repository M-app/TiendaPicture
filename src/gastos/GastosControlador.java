/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gastos;

/**
 *
 * @author Joseph
 */
public class GastosControlador {
    private GastosDAO Gastos ;
    private JDgastos jdgastos;
    
    public GastosControlador() {
        
        Gastos = new GastosDAO();
    }
    
    public void buscarGastoXCodigo(int codigo){
        GastosDTO busqueda = Gastos.buscarGastosXCodigo(codigo);
        if(busqueda != null){
            
             busqueda.getCantidad();
             busqueda.getFecha();
             busqueda.getTipoGasto();
            
        }
    }
     public void insertarGasto(float cantidad, String fecha, String tipoGasto){
        Gastos.insertarGastos(cantidad, fecha, tipoGasto);
    }
} 
