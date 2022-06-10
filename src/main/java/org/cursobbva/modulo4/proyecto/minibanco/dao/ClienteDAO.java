package org.cursobbva.modulo4.proyecto.minibanco.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("clienteDAO")
public class ClienteDAO{
	@PersistenceContext
    private EntityManager em;

	public ClienteDAO(EntityManager em) {
		super();
		this.em = em;
	}
	public ClienteDAO() {}

	public Cliente create(Cliente obj) {
		em.persist(obj);
		return obj;
	}

	public Cliente read(Long id) {
		return em.find(Cliente.class, id);
	}

	public Cliente update(Cliente t) {
		return (Cliente) em.merge(t);
		
	}

	public void delete(Cliente t) {
		t = em.merge(t);
		em.remove(t);
	}

	@SuppressWarnings("unchecked")
	public Collection<Cliente> readAll() {
		return (List<Cliente>) em.createNamedQuery("CLIENTES.buscarTodos").getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Cliente> getClientePorNombre(String nombre) {
		return (List<Cliente>) em.createNamedQuery("CLIENTES.buscarPorNombre").setParameter("nombre", nombre).getResultList();
	}
	
}
