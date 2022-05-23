package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.*;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.cursobbva.modulo4.proyecto.minibanco.daos.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
public class ClienteTestDAO {

	static EntityManagerFactory emf;
	static EntityManager em;
	static EntityTransaction tx;
	
	static Direccion dir;
	Cliente cte;
	ClienteDAO cteDao;


	@BeforeClass
	public static void InicioTest() {
		emf = Persistence.createEntityManagerFactory("minibancoPU");
		em = emf.createEntityManager();
		tx = em.getTransaction();
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
	}
	
	@Before
	public void inicioCadaTest() {
		tx.begin();
		cteDao = new ClienteDAO(em);
	}

	@Test
	public void testContructorClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		String nombre = "nombre";
		String apellido = "apellido";
		String telefono = "telefono";
		String email = "email";
		assertEquals(nombre, cte.getNombre());
		assertEquals(apellido, cte.getApellido());
		assertEquals(telefono, cte.getTelefono());
		assertEquals(email, cte.getEmail());
		assertTrue(cte.getDireccion().equals(dir));
	}
	
	@Test
	public void testGuardarClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		Cliente cteguardado = cteDao.save(cte);
		assertTrue(cteguardado.equals(cte));
	}

	@Test
	public void Excepcion_Nombre_Null() {
		cte = new Cliente(null, "Perez", null, null, null);
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {
			em.persist(cte);
			}
		);
		assertEquals("Nombre Invalido", excep.getMessage());
	}

	@Test
	public void Excepcion_Apellido_Null() {
		cte = new Cliente("nombre", null, null, null, null);
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {
			em.persist(cte);
			}
		);
		assertEquals("Apellido Invalido", excep.getMessage());
	}

	@Test
	public void testGuardarClienteError() {
		cte = new Cliente(null,"apellido", "telefono", "email", dir);
		
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {
			cteDao.save(cte);
			}
		);
		assertEquals("Nombre Invalido", excep.getMessage());
	}

	@After
	public void finalCadaTest() {
		tx.rollback();
	}
	

}
