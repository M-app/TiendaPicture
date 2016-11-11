
package Reportes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ReportesControlador implements ActionListener {
    
    JDreportes vistarepor ;
    ReportesDAO nuevo=new ReportesDAO();
    
    public ReportesControlador (JDreportes vistarepor)
    {
        this.vistarepor=vistarepor;
        
        vistarepor.btnlista.addActionListener(this);//*
        vistarepor.btnclientes.addActionListener(this);//*
        vistarepor.btnexistencia.addActionListener(this);//*
        vistarepor.btnventasdeproductos.addActionListener(this);
        vistarepor.btnlistadopro.addActionListener(this);
        vistarepor.btnmasvendido.addActionListener(this);//*
        
        
    }
  
    public void actionPerformed(ActionEvent ae) {
        
         if(vistarepor.btnlista==ae.getSource())
         {
             nuevo.Reporte();
         }
            if(vistarepor.btnmasvendido==ae.getSource())
            {
             nuevo.Reporte2();
            }
                if(vistarepor.btnclientes==ae.getSource())
                {
                nuevo.Reporte3();
                }
                     if(vistarepor.btnexistencia==ae.getSource())
                    {
                    nuevo.reporte4();
                    }
                     
                      if(vistarepor.btnventasdeproductos==ae.getSource())
                        {
                        nuevo.reporte5();
                        }
                        if(vistarepor.btnlistadopro==ae.getSource())
                         {
                            nuevo.reporte6();
                            }
        
        
        
      
        
    }
      
    
    
    
}
