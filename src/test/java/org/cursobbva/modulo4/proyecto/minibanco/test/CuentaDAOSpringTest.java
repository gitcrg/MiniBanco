package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.cursobbva.modulo4.proyecto.minibanco.dao.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.dao.CuentaDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

/**
 * 
 * @author Cristian Gutierrez
 *
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:/spring/contexto-jpa.xml")
@Transactional
class CuentaDAOSpringTest {

	@Autowired
	private ClienteDAO cteDao;
	@Autowired
	private CuentaDAO ctaDao;
    @PersistenceContext
    private EntityManager em;     
	
	Direccion dir;
	Cliente cte;
	Cuenta cta;

	@BeforeEach
	public void inicioCadaTest() {
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);
	}


	@Test
	public void testCreateCuentaOk() {
		cta = new CuentaExtranjera(LocalDate.now(), 0D, 0D, 0D, null, cte, TipoMoneda.USD );
		cteDao.create(cte);
		ctaDao.create(cta);
		em.flush();
 		assertNotNull(cta.getNumero());
 		em.clear();
		Cuenta ctaguardada = em.find(Cuenta.class, cta.getNumero());
		assertTrue(ctaguardada.equals(cta));
 		assertNotNull(ctaguardada);
 		assertFalse(cta == ctaguardada);
	}

	@Test
	public void testReadCuentaOk() {
		cta = new CuentaExtranjera(LocalDate.now(), 0D, 0D, 0D, null, cte, TipoMoneda.USD );
		cteDao.create(cte);
		ctaDao.create(cta);
		em.flush();
		Cuenta ctaguardada = ctaDao.read(cta.getNumero());
		assertTrue(ctaguardada.equals(cta));
	}
	
	@Test
	public void testUpdateCuentaOk() {
		cta = new CuentaExtranjera(LocalDate.now(), 0D, 0D, 0D, null, cte, TipoMoneda.USD );
		cteDao.create(cte);
		ctaDao.create(cta);
		em.flush();
		assertNotNull(cta.getNumero());
 		em.clear();
		cta.setFechaDeCierre(LocalDate.now());
		ctaDao.update(cta);
		em.flush();
		Cuenta ctaeActualizada = ctaDao.read(cta.getNumero());
		assertTrue(!ctaDao.read(ctaeActualizada.getNumero()).cuentaAbierta());
	}

	@Test
	public void testUpdateSaldoInicialOk() {
		cta = new CuentaExtranjera(LocalDate.now(), 0D, 0D, 0D, null, cte, TipoMoneda.USD );
		cteDao.create(cte);
		ctaDao.create(cta);
		em.flush();
		assertNotNull(cta.getNumero());
 		em.clear();
 		Cuenta ctab = ctaDao.read(cta.getNumero());
 		ctab.setSaldoInicial(12345D);
		ctaDao.update(ctab);
		em.flush();em.clear();
		Cuenta ctaActualizada = ctaDao.read(ctab.getNumero());
		assertEquals(0,ctaActualizada.getSaldoInicial());
		assertEquals(12345D,ctab.getSaldoInicial());
	}

	
	@Test
	public void testDeleteCuentaOk() {
		cta = new CuentaExtranjera(LocalDate.now(), 0D, 0D, 0D, null, cte, TipoMoneda.USD );
		cteDao.create(cte);
		ctaDao.create(cta);
		em.flush();
 		assertNotNull(cte.getId());
 		em.clear();
		Cuenta ctaeActualizada = ctaDao.read(cta.getNumero());
		assertTrue(em.contains(ctaeActualizada));
		ctaDao.delete(ctaeActualizada);
		assertTrue(!em.contains(ctaeActualizada));
		assertTrue(!em.contains(cta));
	}

	
}
