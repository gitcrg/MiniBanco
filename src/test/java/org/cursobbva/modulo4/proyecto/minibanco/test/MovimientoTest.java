package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Extraccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Movimiento;
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

public class MovimientoTest {

	Direccion dir;
	Cliente cte;
	Cuenta cta;
	Movimiento mov;
	Deposito dep;
	Extraccion ext;
	Compra cmp;
	Venta vnt;
	TransferenciaCredito cred;
	TransferenciaDebito debi;
	
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();

	
	@BeforeEach
	public void crear() {
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);
		cta = new CuentaLocal(LocalDate.now(), 0D, 0D, 1000D, null, cte );
	}

	@Test
	public void testContructorDepositoOk() {
		dep = new Deposito(LocalDateTime.now(), 2000D, "deposito 1", "cajaCajero 1");
		Double monto = 2000D;
		String descripcion = "deposito 1";
		String cajero = "cajaCajero 1";
		assertEquals(monto, dep.getMonto(),0);
		assertEquals(descripcion, dep.getDescripcion());
		assertEquals(cajero, dep.getCajaCajero());
	}
	
	@Test
	public void testContructorExtraccionOk() {
		ext = new Extraccion(LocalDateTime.now(), 500D, "extraccion1", "caja2");
		Double monto = 500D;
		String descripcion = "extraccion1";
		String cajero = "caja2";
		assertEquals(monto, ext.getMonto(),0);
		assertEquals(descripcion, ext.getDescripcion());
		assertEquals(cajero, ext.getCajaCajero());
	}

	@Test
	public void testContructorCompraOk() {
		cmp = new Compra(LocalDateTime.now(), 500D, "compra-dolares", 205D, 5D);
		Double monto = 500D;
		String descripcion = "compra-dolares";
		Double cotizacion = 205D;
		Double comision = 5D;
		assertEquals(monto, cmp.getMonto(),0);
		assertEquals(descripcion, cmp.getDescripcion());
		assertEquals(cotizacion, cmp.getCotizacion(),0);
		assertEquals(comision, cmp.getComision(),0);
	}

	@Test
	public void testContructorVentaOk() {
		vnt = new Venta(LocalDateTime.now(), 100D, "venta-dolares", 195D, 5D);
		Double monto = 100D;
		String descripcion = "venta-dolares";
		Double cotizacion = 195D;
		Double comision = 5D;
		assertEquals(monto, vnt.getMonto(),0);
		assertEquals(descripcion, vnt.getDescripcion());
		assertEquals(cotizacion, vnt.getCotizacion(),0);
		assertEquals(comision, vnt.getComision(),0);
	}
	
	@Test
	public void testContructorCreditoOk() {
		cred = new TransferenciaCredito(LocalDateTime.now(), 35000D, "credito-tran", cta);
		Double monto = 35000D;
		String descripcion = "credito-tran";
		assertEquals(monto, cred.getMonto(),0);
		assertEquals(descripcion, cred.getDescripcion());
		assertTrue(cred.getCuentaOrigen().equals(cta));
	}
	
	@Test
	public void testContructorDebitoOk() {
		debi = new TransferenciaDebito(LocalDateTime.now(), 5000D, "debito-tran", cta);
		Double monto = 5000D;
		String descripcion = "debito-tran";
		assertEquals(monto, debi.getMonto(),0);
		assertEquals(descripcion, debi.getDescripcion());
		assertTrue(debi.getCuentaDestino().equals(cta));
	}
	
	@Test
	public void testValidacionCamposObligatoriosTransDebi() {
		LocalDateTime fechaHora = null;
		Double monto = 0D;
		String descripcion = "";
		Cuenta cta = null;
		
		debi = new TransferenciaDebito(fechaHora, monto, descripcion, cta);

		Set<ConstraintViolation<TransferenciaDebito>> violations = validator.validate(debi);
		assertTrue(!violations.isEmpty());
		assertEquals(6,violations.size());

	}

	@Test
	public void testValidacionCamposObligatoriosTransCred() {
		LocalDateTime fechaHora = null;
		Double monto = 0D;
		String descripcion = "";
		Cuenta cta = null;
		
		cred = new TransferenciaCredito(fechaHora, monto, descripcion, cta);

		Set<ConstraintViolation<TransferenciaCredito>> violations = validator.validate(cred);
		assertTrue(!violations.isEmpty());
		assertEquals(6,violations.size());

	}
	
	
}

