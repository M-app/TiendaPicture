package compras;

import detalleCompras.DetalleComprasController;
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
import proveedores.Proveedores;
import proveedores.ProveedoresDAO;
import proveedores.ProveedoresDTO;

public class ComprasController {
    
    private final ComprasGUI comprasGui;
    private final ComprasDAO comprasDao;
    
    private Proveedores proveedores;
    private Productos productos;
    
    private final Map<String,ProductosDTO> mHashProductos = new HashMap();
    private final Map<String,ProveedoresDTO> mHashProveedores = new HashMap();
    
    DetalleComprasController detalleComprasController;
    public ComprasController(ComprasGUI gui) {
        this.comprasGui = gui;
        comprasDao = new ComprasDAO();
        proveedores = new ProveedoresDAO();
        productos = new ProductosDAO();
        detalleComprasController = new DetalleComprasController();
    }
    
    public void llenarTabla(int codigoProducto){
        ProductosDTO producto = productos.buscarProductoXCodigo(codigoProducto);
        Object[] columnas = new Object[9];
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
    
    public void insertarDetalleCompra(int idCompra){
        for(int i = 0; i < comprasGui.tblProductos.getRowCount();i++){
            detalleComprasController.insertarDetalleCompras(
                    Integer.parseInt(comprasGui.txtCantidad.getText()), 
                    Float.parseFloat(comprasGui.txtSubTotal.getText()), 
                    idCompra, 
                    Integer.parseInt(comprasGui.tblProductos.getValueAt(i, 0).toString()));
        }
    }
    
    public float getPrecioCosto(int codigoProducto){
        float retValue = productos.buscarProductoXCodigo(codigoProducto).getPrecioCosto();
        return retValue;
    }
    
    public String getSubtotal(int cantidad, float precioCosto){
        return (cantidad * precioCosto) + "";
    }
   
    public void llenarComboProductos(){
        for(ProductosDTO producto : productos.buscarProductos()){
            mHashProductos.put(producto.getDescripcion(), producto);
            comprasGui.comboProductos.addItem(producto.getDescripcion());
        }
    }
    
    public ProductosDTO getProductoXDescripcion(String descripcion){
        return mHashProductos.get(descripcion);
    }
    
    public ProveedoresDTO getProveedorXNomContacto(String nomContacto){
        return mHashProveedores.get(nomContacto);
    }
    
    public void llenarComboProveedores(){
        for(ProveedoresDTO proveedor : proveedores.buscarProveedores()){
            mHashProveedores.put(proveedor.getNomContacto(), proveedor);
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
    
    public String getFecha(){
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date); //29/10/2016
    }
    
    public int getUltimoIdCompra(){
        ArrayList<ComprasDTO> listaCompras =  (ArrayList) comprasDao.buscarCompras();
        return listaCompras.get(listaCompras.size()-1).getIdCompra();
    }
    
    public float getMonto(){
        float retValue = 0;
        for(int i = 0; i< comprasGui.tblProductos.getRowCount() ; i++){
            retValue += Float.parseFloat(comprasGui.tblProductos.getValueAt(i, 8).toString());
        }
        return retValue;
    }
    
    public void insertarCompra(float monto, String fecha, int nit,int noFactura, String direccion,int codigoProveedor){
        comprasDao.insertarCompras(monto, fecha, nit, noFactura, direccion,codigoProveedor);
    }
    
    public void eliminarCompra(int codigo){
        comprasDao.eliminarCompras(codigo);
    }
}
