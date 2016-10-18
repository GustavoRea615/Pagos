package mx.edu.utng.tacho.datos;

import org.hibernate.HibernateException;

import mx.edu.utng.tacho.modelo.Compra;


public class CompraDAO extends DAO<Compra> {

	public CompraDAO() {
		super(new Compra());	
	}
	
	public Compra getOneById(Compra compra) throws HibernateException {
		return super.getOneById(compra.getId());
	}
}
