package org.cursobbva.modulo4.proyecto.minibanco.daos;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Movimiento;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.springframework.stereotype.Repository;

@Repository("movimientoDAO")
public class MovimientoDAO{
	@PersistenceContext
	EntityManager em;
	
	public MovimientoDAO(EntityManager em) {
	      this.em = em;
	}
	public MovimientoDAO() {}

	public Movimiento find(Long id) {
		return em.find(Movimiento.class, id);
	}

	public Movimiento create(Movimiento obj) {
		// TODO Auto-generated method stub
		em.persist(obj);
		return obj;
	}

	public Movimiento read(Long id) {
		// TODO Auto-generated method stub
		return em.find(Movimiento.class, id);
	}

	public Movimiento update(Movimiento t) {
		// TODO Auto-generated method stub
		return (Movimiento) em.merge(t);
		
	}

	public void delete(Movimiento t) {
		// TODO Auto-generated method stub
		t = em.merge(t);
		em.remove(t);
	}

	public Collection<Movimiento> readAll() {
		// TODO Auto-generated method stub
		return null;
	}


}
