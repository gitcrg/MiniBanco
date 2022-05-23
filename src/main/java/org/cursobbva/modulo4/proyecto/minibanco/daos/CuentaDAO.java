package org.cursobbva.modulo4.proyecto.minibanco.daos;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;

public class CuentaDAO implements DAO<Cuenta> {
	EntityManager em;
	
	public CuentaDAO(EntityManager em) {
	      this.em = em;
	   }

	public Cuenta find(Long id) {
		return em.find(Cuenta.class, id);
	}

	public Cuenta save(Cuenta obj) {
		// TODO Auto-generated method stub
		checkTransaction();
		em.persist(obj);
		em.flush();
		em.refresh(obj);
		return obj;
	}

	public Cuenta read(Long id) {
		// TODO Auto-generated method stub
		checkTransaction();
		return em.find(Cuenta.class, id);
	}

	public Cuenta update(Cuenta t) {
		// TODO Auto-generated method stub
		checkTransaction();
		return (Cuenta) em.merge(t);
		
	}

	public void delete(Cuenta t) {
		// TODO Auto-generated method stub
		checkTransaction();
		t = em.merge(t);
		em.remove(t);
	}

	public Collection<Cuenta> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void checkTransaction() {
		if (!em.getTransaction().isActive())
			throw new RuntimeException("Transacción inactiva");
	}
	
	@SuppressWarnings("unchecked")
	public List<CuentaExtranjera> getCuentaPorMoneda(TipoMoneda moneda) {
		return (List<CuentaExtranjera>) em.createNamedQuery("Cuenta.cuentaByMoneda").setParameter("moneda", moneda).getResultList();
	}
	
	
}

