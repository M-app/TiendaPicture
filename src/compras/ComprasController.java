package compras;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import proveedores.Proveedores;

public class ComprasController {
    
    private ComprasGUI comprasGui;
    private ComprasDAO comprasDao;
    
    private Proveedores proveedores;

    public ComprasController(ComprasGUI gui) {
        this.comprasGui = gui;
        comprasDao = new ComprasDAO();
    }
    
    public void llenarTabla(){
        ArrayList<ComprasDTO> listaCompras = 
                (ArrayList<ComprasDTO>) comprasDao.buscarCompras();
        DefaultTableModel tableModel = (DefaultTableModel) comprasGui.tblCompras.getModel();
        Object[] rowData = new Object[7];
        for(ComprasDTO obj : listaCompras){
            rowData[0] = obj.getIdCompra();
            rowData[1] = obj.getMonto();
            rowData[2] = obj.getFecha();
            rowData[3] = obj.getNit();
            rowData[4] = obj.getNoFactura();
            rowData[5] = obj.getDireccion();
            rowData[6] = proveedores.buscarProveedoresXCodigo(obj.getCodigoProveedor()).getNomContacto();
            tableModel.addRow(rowData);
        }
    }
    
    public void buscarCompraXCodigo(int codigo){
        ComprasDTO busqueda = comprasDao.buscarComprasXCodigo(codigo);
        if(busqueda != null){
            DefaultTableModel tableModel = (DefaultTableModel) comprasGui.tblCompras.getModel();
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
