package org.cursobbva.modulo4.proyecto.minibanco.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.springframework.stereotype.Repository;

@Repository("cuentaDAO")
public class CuentaDAO{
	@PersistenceContext
	EntityManager em;
	
	public CuentaDAO(EntityManager em) {
	      this.em = em;
	   }
	public CuentaDAO() {}

	public Cuenta create(Cuenta obj) {
		em.persist(obj);
		return obj;
	}

	public Cuenta read(Long id) {
		return em.find(Cuenta.class, id);
	}

	public Cuenta update(Cuenta t) {
		return (Cuenta) em.merge(t);
		
	}

	public void delete(Cuenta t) {
		t = em.merge(t);
		em.remove(t);
	}

	public Collection<Cuenta> readAll() {
		return (List<Cuenta>) em.createNamedQuery("CUENTAS.buscarTodas").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<CuentaExtranjera> getCuentaPorMoneda(TipoMoneda moneda) {
		return (List<CuentaExtranjera>) em.createNamedQuery("Cuenta.cuentaByMoneda").setParameter("moneda", moneda).getResultList();
	}
	
}

