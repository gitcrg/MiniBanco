package org.cursobbva.modulo4.proyecto.minibanco.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Movimiento;

import org.springframework.stereotype.Repository;
/**
 * 
 * @author Cristian Gutierrez
 *
 */

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
		em.persist(obj);
		return obj;
	}

	public Movimiento read(Long id) {
		return em.find(Movimiento.class, id);
	}

	public Movimiento update(Movimiento t) {
		return (Movimiento) em.merge(t);
		
	}

	public void delete(Movimiento t) {
		t = em.merge(t);
		em.remove(t);
	}

	public Collection<Movimiento> readAll() {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Movimiento> getMovimientosPorCuenta(Long idCuenta) {
		return (List<Movimiento>) em.createNamedQuery("MOVIMIENTOS.movimientoByCuenta").setParameter("idCuenta", idCuenta).getResultList();
	}

}
