
package Reportes;

import java.util.HashMap;
import java.util.Map;

import domain.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;


public class ReportesDAO {
    
    
    Conexion conex=new Conexion();
    Connection conn;
    ResultSet consulta,rs;

    
    
       public void Reporte(){
     
      try {

                    conex.conectar();
                    
                    JasperDesign jd=JRXmlLoader.load("C:\\TiendaPicture\\src\\Reportes\\Productos.jrxml");
                    String sql="SELECT producto.`codigo` AS producto_codigo, producto.`Descripcion` AS producto_Descripcion, producto.`tamaño` AS producto_tamaño, producto.`color` AS producto_color, producto.`capacidad` AS producto_capacidad, producto.`marca` AS producto_marca, producto.`tipo` AS producto_tipo, producto.`pcosto` AS producto_pcosto, producto.`existencia` AS producto_existencia, producto.`mganancia` AS producto_mganancia, producto.`ppublico` AS producto_ppublico FROM`producto` producto";
                    JRDesignQuery newQuery=new JRDesignQuery();
                    newQuery.setText(sql);
                    jd.setQuery(newQuery);           
                    //String dir = "C:\\TiendaPicture\\src\\Reportes\\Productos.jrxml";
                    JasperReport reporteJasper = JasperCompileManager.compileReport(jd);
                    JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, null, conex.getConexion());
                    JasperViewer.viewReport(mostrarReporte);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
    
}
               public void Reporte2(){
     
      try {

                    conex.conectar();
                    String dir = "C:\\TiendaPicture\\src\\Reportes\\P vendido.jrxml";
                    JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
                    JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, null, conex.getConexion());
                    JasperViewer.viewReport(mostrarReporte);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
    
}
             public void Reporte3(){
     
      try {

                    conex.conectar();
                    String dir = "C:\\TiendaPicture\\src\\Reportes\\Clientes.jrxml";
                    JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
                    JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, null, conex.getConexion());
                    JasperViewer.viewReport(mostrarReporte);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
    
}
             
             
                      public void reporte4(){
     
      try {      
                 conex.conectar();
                    String dir = "C:\\TiendaPicture\\src\\Reportes\\existencia.jrxml";
                    JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
                    JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, null, conex.getConexion());
                    JasperViewer.viewReport(mostrarReporte);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
}
                      public void reporte5(){
     
      try {      
                 conex.conectar();
                    String dir = "C:\\TiendaPicture\\src\\Reportes\\ventasproducto.jrxml";
                    JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
                    JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, null, conex.getConexion());
                    JasperViewer.viewReport(mostrarReporte);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
}
                      public void reporte6(){
     
      try {      
                 conex.conectar();
                    String dir = "C:\\TiendaPicture\\src\\Reportes\\Proveedores.jrxml";
                    JasperReport reporteJasper = JasperCompileManager.compileReport(dir);
                    JasperPrint mostrarReporte = JasperFillManager.fillReport(reporteJasper, null, conex.getConexion());
                    JasperViewer.viewReport(mostrarReporte);

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
}
    
}
