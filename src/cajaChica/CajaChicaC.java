package cajaChica;

public class CajaChicaC {
    private CajaChicaGUI ccgui;
    private CajaChicaDAO ccdao;
    
    public CajaChicaC(CajaChicaGUI gui){
        this.ccgui = gui;
        ccdao = new CajaChicaDAO();
    }
    public void buscarCajaChicaXCodigo(int codigo){
        CajaChicaDTO ccbusqueda = ccdao.buscarCajaChicaXCodigo(codigo);
        
    }
}
