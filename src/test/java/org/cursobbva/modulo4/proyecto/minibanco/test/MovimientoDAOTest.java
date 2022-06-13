package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.cursobbva.modulo4.proyecto.minibanco.dao.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.dao.CuentaDAO;
import org.cursobbva.modulo4.proyecto.minibanco.dao.MovimientoDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Deposito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Extraccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Movimiento;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

/**
 * TEST para DAO de Movimiento
 * @author Cristian Gutierrez
 *
 */

class MovimientoDAOTest {

	static EntityManagerFactory emf;
	static EntityManager em;
	static EntityTransaction tx;
	
	Extraccion ext;
	MovimientoDAO movDao;

	@BeforeAll
	public static void InicioTest() {
		emf = Persistence.createEntityManagerFactory("minibancoPU");
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	@BeforeEach
	public void inicioCadaTest() {
		tx.begin();
		movDao = new MovimientoDAO(em);
	}


	@Test
	public void testCreateExtraccionOk() {
		ext = new Extraccion(LocalDateTime.now(), 2000.0, "extraccion 1", "cajaCajero 1");
		movDao.create(ext);
		em.flush();
		Movimiento movguardado = em.find(Extraccion.class, ext.getId());
		assertTrue(movguardado.equals(ext));
	}
	
	
	@AfterEach
	public void finalCadaTest() {
		tx.rollback();
	}
	

	
	
}
