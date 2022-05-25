package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
/**
 * 
 * @author Cristian Gutierrez
 *
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
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
	}

	@Test
	public void testContructorCuentaLocalOk() {
		cta = new CuentaLocal(LocalDate.now(), 0F, 0F, 0F, null, cte);

		LocalDate fechacreacion = LocalDate.now();
		float saldoInicial = 0F;
		float saldoActual = 0F;
		float descubierto = 0F;
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
		cta = new CuentaExtranjera(LocalDate.now(), 0F, 0F, 0F, null, cte, TipoMoneda.DOLAR );
		LocalDate fechacreacion = LocalDate.now();
		float saldoInicial = 0F;
		float saldoActual = 0F;
		float descubierto = 0F;
		LocalDate fechaCierre = null;

		assertEquals(fechacreacion, cta.getFechaDeCreacion());
		assertEquals(saldoInicial, cta.getSaldoInicial(),0);
		assertEquals(saldoActual, cta.getSaldoActual(),0);
		assertEquals(descubierto, cta.getDescubiertoAcordado(),0);
		assertEquals(fechaCierre, cta.getFechaDeCierre());
		assertTrue(cta.getTitular().equals(cte));
	}
	

	@Test
	public void testAgregarCotitularCuenta() {
		
		Cliente cli1 = mock(Cliente.class);
		Cliente cli2 = mock(Cliente.class);
		Cliente cli3 = mock(Cliente.class);
		
		cta = new CuentaLocal(LocalDate.now(), 0F, 0F, 0F, null, cte);
		
		cta.agregarCotitular(cli1);
		cta.agregarCotitular(cli2);
		cta.agregarCotitular(cli3);
	
		assertEquals(3, cta.getCotitulares().size());
	}
	
	
//	@Test
//	public void testAgregarMovimientoCuenta() {
//		
//		TransferenciaCredito mov1 = mock(TransferenciaCredito.class);
//		TransferenciaDebito mov2 = mock(TransferenciaDebito.class);
//		Deposito mov3 = mock(Deposito.class);
//		Extraccion mov4 = mock(Extraccion.class);
//		Compra mov5 = mock(Compra.class);
//		Venta mov6 = mock(Venta.class);
//		
//		cta = new CuentaLocal(LocalDate.now(), 0F, 0F, 1000F, null, cte );
//		
//		cta.agregarMovimiento(mov1);
//		cta.agregarMovimiento(mov2);
//		cta.agregarMovimiento(mov3);
//		cta.agregarMovimiento(mov4);
//		cta.agregarMovimiento(mov5);
//		cta.agregarMovimiento(mov6);
//		
//		assertEquals(6, cta.getMovimientos().size());
//	}
	
	@Test
	public void testValidacionCamposObligatorios() {
		LocalDate fechaCreacion = null;
		float saldoInicial = -1;
		float saldoActual = -1;
		float descubierto = -1;
		LocalDate fechaCierre = null;
		Cliente titular = null;
		
		cta = new CuentaLocal(fechaCreacion, saldoInicial, saldoActual, descubierto, fechaCierre, titular);

		Set<ConstraintViolation<Cuenta>> violations = validator.validate(cta);
		assertTrue(!violations.isEmpty());
		assertEquals(5,violations.size());
		
	}

	
}
