package org.cursobbva.modulo4.proyecto.minibanco.daos;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Movimiento;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;

public class MovimientoDAO {
	EntityManager em;
	
	public MovimientoDAO(EntityManager em) {
	      this.em = em;
	   }

	public Movimiento find(Long id) {
		return em.find(Movimiento.class, id);
	}

	public Movimiento save(Movimiento obj) {
		// TODO Auto-generated method stub
		checkTransaction();
		em.persist(obj);
		em.flush();
		em.refresh(obj);
		return obj;
	}

	public Movimiento read(Long id) {
		// TODO Auto-generated method stub
		checkTransaction();
		return em.find(Movimiento.class, id);
	}

	public Movimiento update(Movimiento t) {
		// TODO Auto-generated method stub
		checkTransaction();
		return (Movimiento) em.merge(t);
		
	}

	public void delete(Movimiento t) {
		// TODO Auto-generated method stub
		checkTransaction();
		t = em.merge(t);
		em.remove(t);
	}

	public Collection<Movimiento> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	private void checkTransaction() {
		if (!em.getTransaction().isActive())
			throw new RuntimeException("Transacción inactiva");
	}
	

}
