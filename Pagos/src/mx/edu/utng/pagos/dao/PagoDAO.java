package mx.edu.utng.pagos.dao;

import java.util.List;

import mx.edu.utng.pagos.model.Pago;

public interface PagoDAO {

	void agregarPago(Pago pago);
    void borrarPago(int idPago);
    void cambiarPago(Pago pago);
    List<Pago> desplegarPagos();
    Pago elegirPago(int idPago);
}
