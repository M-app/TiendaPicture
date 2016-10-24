package gastos;

import java.util.Collection;

public interface Gastos {
    GastosDTO buscarGastosXCodigo(int codigo);
    Collection<GastosDTO> buscarGastos();
    void insertarGastos(float cantidad, String fecha, String tipoGasto);
}
