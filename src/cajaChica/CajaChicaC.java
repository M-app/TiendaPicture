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
        if(ccbusqueda != null){
            ccbusqueda.getCantidd();
            ccbusqueda.getFecha();
        }
    }
    public void insertarCajaChica(float cantidad, String fecha, String tipo ){
        ccdao.insertarCajaChica(cantidad, fecha, tipo);
}
    public void eliminarCajaChica(int codigo){
        ccdao.eliminarCajaChica(codigo);
    }
}