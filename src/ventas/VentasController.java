/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import clientes.Clientes;
import clientes.ClientesDAO;
import clientes.ClientesDTO;
import detalleVentas.DetalleVentasController;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import productos.Productos;
import productos.ProductosDAO;
import productos.ProductosDTO;
/**
 *
 * @author Celinda Recinos
 */
public class VentasController {
    
    private final VentasGUI VentasGui;
    private final VentasDAO VentasDao;
    
    private Clientes clientes;
    private Productos productos;
    
    private final Map<String,ProductosDTO> mHashProductos = new HashMap();
    private final Map<String,ClientesDTO> mHashClientes = new HashMap();
    
    DetalleVentasController detalleVentasController;
    public VentasController(VentasGUI gui) {
        this.VentasGui = gui;
        VentasDao = new VentasDAO();
        clientes = new ClientesDAO();
        productos = new ProductosDAO();
        detalleVentasController = new DetalleVentasController();
        
    }
    
    
    public void llenarTabla(int codigoProducto){
        ProductosDTO producto = productos.buscarProductoXCodigo(codigoProducto);
        Object[] columnas = new Object[10];
        columnas[0] = producto.getCodigo();
        columnas[1] = producto.getDescripcion();
        columnas[2] = producto.getTamanio();
        columnas[3] = producto.getColor();
        columnas[4] = producto.getCapacidad();
        columnas[5] = producto.getMarca();
        columnas[6] = producto.getTipo();
        columnas[7] = producto.getPrecioPublico();
        columnas[8] = VentasGui.TxtCantidadPV.getText();
        columnas[9] = Float.parseFloat(VentasGui.TxtCantidadPV.getText())*producto.getPrecioPublico();
        DefaultTableModel modeloTabla = (DefaultTableModel) VentasGui.TblProductosV.getModel();
        modeloTabla.addRow(columnas);
    }
    
    public void insertarDetalleVenta(int idVenta){
        for(int i = 0; i < VentasGui.TblProductosV.getRowCount();i++){
            detalleVentasController.insertarDetalleVentas(
                    Integer.parseInt(VentasGui.TblProductosV.getValueAt(i, 8).toString()), 
                    Float.parseFloat(VentasGui.TblProductosV.getValueAt(i, 9).toString()), 
                    idVenta, 
                    Integer.parseInt(VentasGui.TblProductosV.getValueAt(i,0).toString()));
        }
    }
    
    public float getPrecioPublico(int codigoProducto){
        float retValue = productos.buscarProductoXCodigo(codigoProducto).getPrecioPublico();
        return retValue;
    }
    
    public int getExistencia(int codigoProducto){
        int retValue = productos.buscarProductoXCodigo(codigoProducto).getExistencia();
        return retValue;
    }
    
    public void llenarComboProductosV(){
        for(ProductosDTO producto : productos.buscarProductos()){
            mHashProductos.put(producto.getDescripcion(), producto);
            VentasGui.ComboProductosV.addItem(producto.getDescripcion());
        }
    }
    
    public ProductosDTO getProductoXDescripcion(String descripcion){
        return mHashProductos.get(descripcion);
    }
    
    public ClientesDTO getClienteXNit(String nit){
        return mHashClientes.get(nit);
    }
    
    public ClientesDTO getClienteXNombre(String nombre){
        return mHashClientes.get(nombre);
    }
    
    public ClientesDTO getClienteXApellidos(String apellidos){
        return mHashClientes.get(apellidos);
    }
    
    public void llenarComboClientes(){
        for(ClientesDTO cliente : clientes.buscarClientes()){
            mHashClientes.put(String.valueOf(cliente.getNombre()+" "+cliente.getApellidos()), cliente);
            VentasGui.ComboClientes.addItem(cliente.getNombre()+" "+cliente.getApellidos());
        }
    }
    
    public String getFecha(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date); //29/10/2016
    }
    
    public int getUltimoIdVenta(){
        ArrayList<VentasDTO> listaVentas =  (ArrayList) VentasDao.buscarVentas();
        return listaVentas.get(listaVentas.size()-1).getIdVenta();
    }
    
    public float getMonto(){
        float retValue = 0;
        for(int i = 0; i< VentasGui.TblProductosV.getRowCount() ; i++){
            retValue += Float.parseFloat(VentasGui.TblProductosV.getValueAt(i, 9).toString());
        }
        return retValue;
    }
    
    public void insertarVentas(String fecha, float monto, float descuento, int idCliente) {
        VentasDao.insertarVentas(fecha, monto, descuento, idCliente);
    }
}
