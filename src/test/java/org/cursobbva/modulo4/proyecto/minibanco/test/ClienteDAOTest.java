package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.cursobbva.modulo4.proyecto.minibanco.dao.ClienteDAO;
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
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);
		cteDao.create(cte);
		em.flush();
 		assertNotNull(cte.getId());
 		em.clear();
		Cliente cteguardado = em.find(Cliente.class, cte.getId());
 		assertNotNull(cteguardado);
 		assertFalse(cte == cteguardado);
 		assertEquals(cte.getNombre(), cteguardado.getNombre());
	}

	@Test
	public void testReadClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);
		cteDao.create(cte);
		em.flush();
 		assertNotNull(cte.getId());
 		em.clear();
		Cliente cteguardado = cteDao.read(cte.getId());
 		assertNotNull(cteguardado);
 		assertFalse(cte == cteguardado);
 		assertEquals(cte.getNombre(), cteguardado.getNombre());

	}

	@Test
	public void testUpdateClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);
		cteDao.create(cte);
		em.flush();
 		assertNotNull(cte.getId());
 		em.clear();
		cte.setNombre("nuevo nombre");
		cteDao.update(cte);
		em.flush();
		Cliente cteActualizado = cteDao.read(cte.getId());
		assertEquals("nuevo nombre",cteActualizado.getNombre());
	}

	@Test
	public void testDeleteClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);
		cteDao.create(cte);
		em.flush();
 		assertNotNull(cte.getId());
 		em.clear();
		Cliente cteActualizado = cteDao.read(cte.getId());
		assertTrue(em.contains(cteActualizado));
		cteDao.delete(cteActualizado);
		assertTrue(!em.contains(cteActualizado));
	}

	
	@Test
	public void testCreateClienteErrorNombre() {
		cte = new Cliente(null,"apellido", "telefono", "email@email.com", dir);
		
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {
			cteDao.create(cte);
			}
		);
		assertEquals("Nombre Invalido", excep.getMessage());
	}

	@Test
	public void testCreateClienteErrorApellido() {
		cte = new Cliente("nombre","", "telefono", "email@email.com", dir);
		
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
