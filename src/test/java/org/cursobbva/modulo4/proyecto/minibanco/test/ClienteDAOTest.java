package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.cursobbva.modulo4.proyecto.minibanco.daos.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

class ClienteDAOTest {

	static EntityManagerFactory emf;
	static EntityManager em;
	static EntityTransaction tx;
	
	Direccion dir;
	Cliente cte;
	ClienteDAO cteDao;

	@BeforeAll
	public static void InicioTest() {
		emf = Persistence.createEntityManagerFactory("minibancoPU");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	@BeforeEach
	public void inicioCadaTest() {
		tx.begin();
		cteDao = new ClienteDAO(em);
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
	}


	@Test
	public void testCreateClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		cteDao.create(cte);
		em.flush();
		Cliente cteguardado = em.find(Cliente.class, cte.getId());
		assertTrue(cteguardado.equals(cte));
	}

	@Test
	public void testReadClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		cteDao.create(cte);
		em.flush();
		Cliente cteguardado = cteDao.read(cte.getId());
		assertTrue(cteguardado.equals(cte));
	}

	@Test
	public void testUpdateClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		cteDao.create(cte);
		em.flush();
		cte.setNombre("nuevo nombre");
		Cliente cteActualizado = cteDao.read(cte.getId());
		assertEquals("nuevo nombre",cteActualizado.getNombre());
	}

	@Test
	public void testDeleteClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		cteDao.create(cte);
		em.flush();
		assertTrue(em.contains(cte));
		cteDao.delete(cte);
		assertTrue(!em.contains(cte));
	}

	
	@Test
	public void testCreateClienteErrorNombre() {
		cte = new Cliente(null,"apellido", "telefono", "email", dir);
		
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {
			cteDao.create(cte);
			}
		);
		assertEquals("Nombre Invalido", excep.getMessage());
	}

	@Test
	public void testCreateClienteErrorApellido() {
		cte = new Cliente("nombre","", "telefono", "email", dir);
		
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {
			cteDao.create(cte);
			}
		);
		assertEquals("Apellido Invalido", excep.getMessage());
	}

	
	@AfterEach
	public void finalCadaTest() {
		tx.rollback();
	}
	

	
	
}
