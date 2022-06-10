package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Compra;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Deposito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Extraccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaCredito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaDebito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Venta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Cristian Gutierrez
 *TODO:Revisar por que algunas Validaciones se duplican
 */
public class CuentaTest {

	Direccion dir;
	Cliente cte;
	Cuenta cta;
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();


	@BeforeEach
	public void crearDireccion() {
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		cte = new Cliente("nuevonombre", "nuevoapellido", "telefono", "email@email.com", dir);
	}

	@Test
	public void testContructorCuentaLocalOk() {
		cta = new CuentaLocal(LocalDate.now(), 0D, 0D, 0D, null, cte);

		LocalDate fechacreacion = LocalDate.now();
		Double saldoInicial = 0D;
		Double saldoActual = 0D;
		Double descubierto = 0D;
		LocalDate fechaCierre = null;

		assertEquals(fechacreacion, cta.getFechaDeCreacion());
		assertEquals(saldoInicial, cta.getSaldoInicial(),0);
		assertEquals(saldoActual, cta.getSaldoActual(),0);
		assertEquals(descubierto, cta.getDescubiertoAcordado(),0);
		assertEquals(fechaCierre, cta.getFechaDeCierre());
		assertTrue(cta.getTitular().equals(cte));
	}
	
	@Test
	public void testContructorCuentaExtranjeraOk() {
		cta = new CuentaExtranjera(LocalDate.now(), 0D, 0D, 0D, null, cte, TipoMoneda.USD );
		LocalDate fechacreacion = LocalDate.now();
		Double saldoInicial = 0D;
		Double saldoActual = 0D;
		Double descubierto = 0D
				;
		LocalDate fechaCierre = null;

		assertEquals(fechacreacion, cta.getFechaDeCreacion());
		assertEquals(saldoInicial, cta.getSaldoInicial(),0);
		assertEquals(saldoActual, cta.getSaldoActual(),0);
		assertEquals(descubierto, cta.getDescubiertoAcordado(),0);
		assertEquals(fechaCierre, cta.getFechaDeCierre());
		assertTrue(cta.getTitular().equals(cte));
	}
	
	@Test
	public void testCuentaLocalCambioSaldoOk() {
		cta = new CuentaLocal(LocalDate.now(), 0D, 0D, 0D, null, cte);

		LocalDate fechacreacion = LocalDate.now();
		Double saldoInicial = 0D;
		Double saldoActual = 0D;
		Double descubierto = 0D;
		LocalDate fechaCierre = null;

		assertEquals(fechacreacion, cta.getFechaDeCreacion());
		assertEquals(saldoInicial, cta.getSaldoInicial(),0);
		assertEquals(saldoActual, cta.getSaldoActual(),0);
		assertEquals(descubierto, cta.getDescubiertoAcordado(),0);
		assertEquals(fechaCierre, cta.getFechaDeCierre());
		assertTrue(cta.getTitular().equals(cte));
		
		cta.setSaldoActual(500D);
		assertEquals(500, cta.getSaldoActual(),0);
		
	}


	@Test
	public void testCuentaExtranjeraCambioSaldoOk() {
		cta = new CuentaExtranjera(LocalDate.now(), 0D, 0D, 0D, null, cte, TipoMoneda.USD );
		LocalDate fechacreacion = LocalDate.now();
		Double saldoInicial = 0D;
		Double saldoActual = 0D;
		Double descubierto = 0D
				;
		LocalDate fechaCierre = null;

		assertEquals(fechacreacion, cta.getFechaDeCreacion());
		assertEquals(saldoInicial, cta.getSaldoInicial(),0);
		assertEquals(saldoActual, cta.getSaldoActual(),0);
		assertEquals(descubierto, cta.getDescubiertoAcordado(),0);
		assertEquals(fechaCierre, cta.getFechaDeCierre());
		assertTrue(cta.getTitular().equals(cte));
		
		cta.setSaldoActual(500D);
		assertEquals(500, cta.getSaldoActual(),0);
	}
	
	@Test
	public void testCuentaLocalCambioTitularOk() {
		cta = new CuentaLocal(LocalDate.now(), 0D, 0D, 0D, null, cte);

		LocalDate fechacreacion = LocalDate.now();
		Double saldoInicial = 0D;
		Double saldoActual = 0D;
		Double descubierto = 0D;
		LocalDate fechaCierre = null;

		assertEquals(fechacreacion, cta.getFechaDeCreacion());
		assertEquals(saldoInicial, cta.getSaldoInicial(),0);
		assertEquals(saldoActual, cta.getSaldoActual(),0);
		assertEquals(descubierto, cta.getDescubiertoAcordado(),0);
		assertEquals(fechaCierre, cta.getFechaDeCierre());
		assertTrue(cta.getTitular().equals(cte));

		Cliente nuevotitular = new Cliente("nuevonombre", "nuevoapellido", "telefono", "email@email.com", dir);
		
		cta.setTitular(nuevotitular);
		assertEquals(nuevotitular, cta.getTitular());
		
	}


	@Test
	public void testCuentaExtranjeraCambioTitularOk() {
		cta = new CuentaExtranjera(LocalDate.now(), 0D, 0D, 0D, null, cte, TipoMoneda.USD );
		LocalDate fechacreacion = LocalDate.now();
		Double saldoInicial = 0D;
		Double saldoActual = 0D;
		Double descubierto = 0D
				;
		LocalDate fechaCierre = null;

		assertEquals(fechacreacion, cta.getFechaDeCreacion());
		assertEquals(saldoInicial, cta.getSaldoInicial(),0);
		assertEquals(saldoActual, cta.getSaldoActual(),0);
		assertEquals(descubierto, cta.getDescubiertoAcordado(),0);
		assertEquals(fechaCierre, cta.getFechaDeCierre());
		assertTrue(cta.getTitular().equals(cte));
		
		Cliente nuevotitular = new Cliente("nuevonombre", "nuevoapellido", "telefono", "email@email.com", dir);
		
		cta.setTitular(nuevotitular);
		assertEquals(nuevotitular, cta.getTitular());
	}
	

	
	@Test
	public void testValidacionCamposObligatorios() {
		LocalDate fechaCreacion = null;
		Double saldoInicial = null;
		Double saldoActual = null;
		Double descubierto = null;
		LocalDate fechaCierre = null;
		Cliente titular = null;
		
		cta = new CuentaLocal(fechaCreacion, saldoInicial, saldoActual, descubierto, fechaCierre, titular);

		Set<ConstraintViolation<Cuenta>> violations = validator.validate(cta);
		assertTrue(!violations.isEmpty());
		assertEquals(6,violations.size());
		
	}

	
	@Test
	public void testAgregarMovimientoCuenta() {
		
		TransferenciaCredito mov1 = mock(TransferenciaCredito.class);
		TransferenciaDebito mov2 = mock(TransferenciaDebito.class);
		Deposito mov3 = mock(Deposito.class);
		Extraccion mov4 = mock(Extraccion.class);
		Compra mov5 = mock(Compra.class);
		Venta mov6 = mock(Venta.class);
		
		cta = new CuentaLocal(LocalDate.now(), 0D, 0D, 1000D, null, cte );
		
		cta.agregarMovimiento(mov1);
		cta.agregarMovimiento(mov2);
		cta.agregarMovimiento(mov3);
		cta.agregarMovimiento(mov4);
		cta.agregarMovimiento(mov5);
		cta.agregarMovimiento(mov6);
		
		assertEquals(6, cta.getMovimientos().size());
	}
	
	@Test
	public void testAgregarCotitular() {
		
		Cliente cte1 = mock(Cliente.class);
		Cliente cte2 = mock(Cliente.class);
		Cliente cte3 = mock(Cliente.class);
		Cliente cte4 = mock(Cliente.class);
		Cliente cte5 = mock(Cliente.class);
		
		cta = new CuentaLocal(LocalDate.now(), 0D, 0D, 1000D, null, cte );

		cta.agregarCotitular(cte1);
		cta.agregarCotitular(cte2);
		cta.agregarCotitular(cte3);
		cta.agregarCotitular(cte4);
		cta.agregarCotitular(cte5);
		
		assertEquals(5, cta.getCotitulares().size());
	}

	@Test
	public void testAgregarCotitularDuplicado() {
		Cliente cte1 = mock(Cliente.class);
		Cliente cte2 = mock(Cliente.class);
		Cliente cte3 = mock(Cliente.class);

		cta = new CuentaLocal(LocalDate.now(), 0D, 0D, 1000D, null, cte);

		try {
			cta.agregarCotitular(cte1);
			cta.agregarCotitular(cte2);
			cta.agregarCotitular(cte3);
			cta.agregarCotitular(cte2);
		} catch (IllegalArgumentException e) {
			assertEquals("Cliente ya es cotitular de la cuenta", e.getMessage());
		}

	}
	
	@Test
	public void testQuitarCotitular() {
		
		Cliente cte1 = mock(Cliente.class);
		Cliente cte2 = mock(Cliente.class);
		Cliente cte3 = mock(Cliente.class);
		Cliente cte4 = mock(Cliente.class);
		Cliente cte5 = mock(Cliente.class);
		
		cta = new CuentaLocal(LocalDate.now(), 0D, 0D, 1000D, null, cte );

		cta.agregarCotitular(cte1);
		cta.agregarCotitular(cte2);
		cta.agregarCotitular(cte3);
		cta.agregarCotitular(cte4);
		cta.agregarCotitular(cte5);
		
		assertEquals(5, cta.getCotitulares().size());
		
		cta.quitarCotitular(cte1);
		
		assertEquals(4, cta.getCotitulares().size());
	}

	@Test
	public void testCuentaDelClienteOK() {
		cta = new CuentaLocal(LocalDate.now(), 0D, 0D, 0D, null, cte);
	
		assertTrue(cte.cuentaDelCliente(cta));

	}

	@Test
	public void testCuentaDelClienteMal() {
		Cliente cte1 = mock(Cliente.class);
		
		cta = new CuentaLocal(LocalDate.now(), 0D, 0D, 0D, null, cte);
		
		assertTrue(!cte1.cuentaDelCliente(cta));

	}

	
	
}

