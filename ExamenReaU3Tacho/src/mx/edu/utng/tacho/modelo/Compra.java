package mx.edu.utng.tacho.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="tbl_compra")
public class Compra {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_compra")
	private Long id;
	
	private String descripcion;
	
	private int cantidad;
	
	@Column(name = "precio_unitario")
	private double precioUnitario;

	
	private double total;
	
	@ManyToOne
	@JoinColumn(name="id_proveedor")
	private Proveedor proveedor;
	
	public Compra() {
		id = 0L;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	


	public Proveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
}

