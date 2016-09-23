package mx.edu.utng.pagos.model;

public class Pago {
	private int idPago;
	   private double subtotal;
	   private double propina;
	   private double impuesto;
	   
	   public Pago() {
	        this(0,0.0,0.0,0.0);
	    }
	   
	   

	public Pago(int idPago, double subtotal, double propina, double impuesto) {
		super();
		this.idPago = idPago;
		this.subtotal = subtotal;
		this.propina = propina;
		this.impuesto = impuesto;
	}



	@Override
	public String toString() {
		return "Pago [idPago=" + idPago + ", subtotal=" + subtotal + ", propina=" + propina + ", impuesto=" + impuesto
				+ "]";
	}



	public int getIdPago() {
		return idPago;
	}

	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}

	public double getSubtotal() {
		return subtotal;
	}

	

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}



	public double getPropina() {
		return propina;
	}

	public void setPropina(double propina) {
		this.propina = propina;
	}

	public double getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(double impuesto) {
		this.impuesto = impuesto;
	}


}
