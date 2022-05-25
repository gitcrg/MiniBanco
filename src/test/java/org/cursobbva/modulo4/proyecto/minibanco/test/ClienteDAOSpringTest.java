package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.cursobbva.modulo4.proyecto.minibanco.daos.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:/spring/contexto-jpa.xml")
@Transactional
class ClienteDAOSpringTest {

	@Autowired
	private ClienteDAO clienteDao;
    @PersistenceContext
    private EntityManager em;     
	
	Direccion dir;
	Cliente cte;

	@BeforeEach
	public void inicioCadaTest() {
//		cteDao = new ClienteDAO(em);
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
	}

	
    @Test
	public void testCreateClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		clienteDao.create(cte);
 		em.flush();
 		assertNotNull(cte.getId());
 		
 		em.clear();
 		Cliente cteb = em.find(Cliente.class, cte.getId());
 		assertNotNull(cteb);
 		assertFalse(cte == cteb);
 		assertEquals(cte.getNombre(), cteb.getNombre());
	}
    
	@Test
	public void testReadClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		clienteDao.create(cte);
		em.flush();
		Cliente cteguardado = clienteDao.read(cte.getId());
		assertTrue(cteguardado.equals(cte));
	}

	@Test
	public void testUpdateClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		clienteDao.create(cte);
		em.flush();
		cte.setNombre("nuevo nombre");
		Cliente cteActualizado = clienteDao.read(cte.getId());
		assertEquals("nuevo nombre",cteActualizado.getNombre());
	}

	@Test
	public void testDeleteClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		clienteDao.create(cte);
		em.flush();
		assertTrue(em.contains(cte));
		clienteDao.delete(cte);
		assertTrue(!em.contains(cte));
	}
	
//	@Test
//	public void testCreateClienteErrorNombre()  throws Exception {
//		cte = new Cliente(null,"apellido", "telefono", "email", dir);
//		
//		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {
//			clienteDao.create(cte);
//			}
//		);
//		assertEquals("Nombre Invalido", excep.getMessage());
//	}

//	@Test
//	public void testCreateClienteErrorApellido() {
//		cte = new Cliente("nombre","", "telefono", "email", dir);
//		
//		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {
//			cteDao.create(cte);
//			}
//		);
//		assertEquals("Apellido Invalido", excep.getMessage());
//	}


	
}
