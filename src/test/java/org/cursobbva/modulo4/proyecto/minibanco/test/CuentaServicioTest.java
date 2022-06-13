package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.cursobbva.modulo4.proyecto.minibanco.dao.ClienteDAO;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.servicio.ServicioCuenta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

/**
 * TEST de Agregar Cotitular en una Cuenta
 * @author Cristian Gutierrez
 *
 */

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:/spring/contexto-jpa-test.xml")
@Transactional
class CuentaServicioTest {
	@Autowired
	private ServicioCuenta servicioCuenta;
	
	@BeforeEach
	public void inicioCadaTest() {

	}

	@Test
	public void testCuentaInexistente() {
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {servicioCuenta.leerCuentaById(0L);});
		assertEquals("Cuenta Inexistente", excep.getMessage());
	}

	
	@Test
	public void testAgregarCotitularClienteInexistente() {
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {servicioCuenta.agregarCotitular(50L, 1L);});
		assertEquals("Cliente Inexistente", excep.getMessage());
	}

	@Test
	public void testAgregarCotitularCuentaInexistente() {
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {servicioCuenta.agregarCotitular(1L, 50L);});
		assertEquals("Cuenta Inexistente", excep.getMessage());
	}

	@Test
	public void testAgregarCotitularCuentaCerrada() {
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {servicioCuenta.agregarCotitular(1L, 2L);});
		assertEquals("Cuenta cerrada", excep.getMessage());
	}


	@Test
	public void testAgregarCotitularClienteEsTitular() {
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {servicioCuenta.agregarCotitular(1L, 1L);});
		assertEquals("El cliente ya es titular de la cuenta", excep.getMessage());
	}


	@Test
	public void testAgregarCotitularClienteEsCoTitular() {
		IllegalArgumentException excep = assertThrows(IllegalArgumentException.class, () -> {servicioCuenta.agregarCotitular(1L, 4L);});
		assertEquals("El cliente ya es cotitular de la cuenta", excep.getMessage());
	}

	@Test
	public void testAagregarCotitulaOK() {
		Cuenta cta = servicioCuenta.agregarCotitular(4L, 1L);
		assertEquals(1,cta.getCotitulares().size(),0);
		
	}
	
}
