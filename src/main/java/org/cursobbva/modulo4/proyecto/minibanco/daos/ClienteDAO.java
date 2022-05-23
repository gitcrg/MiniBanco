package org.cursobbva.modulo4.proyecto.minibanco.daos;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;

public class ClienteDAO implements DAO<Cliente> {
	EntityManager em;
	
	public ClienteDAO(EntityManager em) {
	      this.em = em;
	   }

	public Cliente find(Long id) {
		return em.find(Cliente.class, id);
	}

	public Cliente save(Cliente obj) {
		// TODO Auto-generated method stub
		checkTransaction();
		em.persist(obj);
		em.flush();
		em.refresh(obj);
		return obj;
	}

	public Cliente read(Long id) {
		// TODO Auto-generated method stub
		checkTransaction();
		return em.find(Cliente.class, id);
	}

	public Cliente update(Cliente t) {
		// TODO Auto-generated method stub
		checkTransaction();
		return (Cliente) em.merge(t);
		
	}

	public void delete(Cliente t) {
		// TODO Auto-generated method stub
		checkTransaction();
		t = em.merge(t);
		em.remove(t);
	}

	public Collection<Cliente> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void checkTransaction() {
		if (!em.getTransaction().isActive())
			throw new RuntimeException("Transacción inactiva");
	}
	
	@SuppressWarnings("unchecked")
	public List<Cliente> getClientePorNombre(String nombre) {
		return (List<Cliente>) em.createNamedQuery("Cliente.clientesByNombre").setParameter("nombre", nombre).getResultList();
	}
	
	
}
