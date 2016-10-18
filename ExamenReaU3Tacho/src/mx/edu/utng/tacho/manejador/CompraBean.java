package mx.edu.utng.tacho.manejador;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import mx.edu.utng.tacho.datos.CompraDAO;
import mx.edu.utng.tacho.datos.ProveedorDAO;
import mx.edu.utng.tacho.modelo.Compra;
import mx.edu.utng.tacho.modelo.Proveedor;



@ManagedBean
@SessionScoped
public class CompraBean implements Serializable {
	
	private List<Compra> compras;
	private Compra compra;
	private List<Proveedor> proveedores;
	
	
	public CompraBean() {
		compra = new Compra(); 
	}


	public String listar(){
		CompraDAO dao = new CompraDAO();
		try {
			compras = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Compras";
	}
	
	public String eliminar(){
		CompraDAO dao = new CompraDAO();
		try {
			dao.delete(compra);
			compras = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Eliminar";
	}
	
	public String agregar(){
		compra = new Compra();
		compra.setProveedor(new Proveedor());
		try{
			proveedores = new ProveedorDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Agregar";
	}
	
	public String guardar(){
		CompraDAO dao = new CompraDAO();
		try {
			if (compra.getId() != 0) {
				dao.update(compra);
			} else {
				dao.insert(compra);
			}
			compras = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Guardar";
	}
	
	public String cancelar(){
		return "Cancelar";
	}
	
	public String editar(Compra compra){
		this.compra = compra;
		try{
			proveedores = new ProveedorDAO().getAll();
		} catch (Exception e){
			e.printStackTrace();
		}
		return "Editar";
	}


	public List<Compra> getCompras() {
		return compras;
	}


	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}


	public Compra getCompra() {
		return compra;
	}


	public void setCompra(Compra compra) {
		this.compra = compra;
	}


	public List<Proveedor> getProveedores() {
		return proveedores;
	}


	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}


	
}