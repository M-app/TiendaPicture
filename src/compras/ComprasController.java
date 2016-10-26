package compras;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import productos.Productos;
import productos.ProductosDTO;
import proveedores.Proveedores;
import proveedores.ProveedoresDTO;

public class ComprasController {
    
    private final ComprasGUI comprasGui;
    private final ComprasDAO comprasDao;
    
    private Proveedores proveedores;
    private Productos productos;

    public ComprasController(ComprasGUI gui) {
        this.comprasGui = gui;
        comprasDao = new ComprasDAO();
    }
    
    public void llenarTabla(int codigoProducto){
        ProductosDTO producto = productos.buscarProductoXCodigo(codigoProducto);
        Object[] columnas = new Object[8];
        columnas[0] = producto.getCodigo();
        columnas[1] = producto.getDescripcion();
        columnas[2] = producto.getTamanio();
        columnas[3] = producto.getColor();
        columnas[4] = producto.getCapacidad();
        columnas[5] = producto.getMarca();
        columnas[6] = producto.getTipo();
        columnas[7] = producto.getPrecioCosto();
        columnas[8] = Float.parseFloat(comprasGui.txtSubTotal.getText());
        DefaultTableModel modeloTabla = (DefaultTableModel) comprasGui.tblProductos.getModel();
        modeloTabla.addRow(columnas);
    }
    
    public String getSubtotal(int cantidad, float precioCosto){
        return (cantidad * precioCosto) + "";
    }
   
    public void llenarComboProductos(){
        for(ProductosDTO producto : productos.buscarProductos()){
            comprasGui.comboProductos.addItem(producto.getDescripcion());
        }
    }
    
    public void llenarComboProveedores(){
        for(ProveedoresDTO proveedor : proveedores.buscarProveedores()){
            comprasGui.comboProveedor.addItem(proveedor.getNomContacto());
        }
    }
    
    public void buscarCompraXCodigo(int codigo){
        ComprasDTO busqueda = comprasDao.buscarComprasXCodigo(codigo);
        if(busqueda != null){
            DefaultTableModel tableModel = (DefaultTableModel) comprasGui.tblProductos.getModel();
            Object[] rowData = new Object[7];
            rowData[0] = busqueda.getIdCompra();
            rowData[1] = busqueda.getMonto();
            rowData[2] = busqueda.getFecha();
            rowData[3] = busqueda.getNit();
            rowData[4] = busqueda.getNoFactura();
            rowData[5] = busqueda.getDireccion();
            rowData[6] = proveedores.buscarProveedoresXCodigo(busqueda.getCodigoProveedor()).getNomContacto();
            tableModel.addRow(rowData);
        }
    }
    
    public void insertarCompra(float monto, String fecha, int nit,int noFactura, String direccion,int codigoProveedor){
        comprasDao.insertarCompras(monto, fecha, nit, noFactura, direccion,codigoProveedor);
    }
    
    public void eliminarCompra(int codigo){
        comprasDao.eliminarCompras(codigo);
    }
}
