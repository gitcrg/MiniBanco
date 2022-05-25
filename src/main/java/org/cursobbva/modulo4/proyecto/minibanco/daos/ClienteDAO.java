package org.cursobbva.modulo4.proyecto.minibanco.daos;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
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
		// TODO Auto-generated method stub
		em.persist(obj);
		return obj;
	}

	public Cliente read(Long id) {
		// TODO Auto-generated method stub
		return em.find(Cliente.class, id);
	}

	public Cliente update(Cliente t) {
		// TODO Auto-generated method stub
		return (Cliente) em.merge(t);
		
	}

	public void delete(Cliente t) {
		// TODO Auto-generated method stub
		t = em.merge(t);
		em.remove(t);
	}

	public Collection<Cliente> readAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("unchecked")
	public List<Cliente> getClientePorNombre(String nombre) {
		return (List<Cliente>) em.createNamedQuery("Cliente.clientesByNombre").setParameter("nombre", nombre).getResultList();
	}

	
}
