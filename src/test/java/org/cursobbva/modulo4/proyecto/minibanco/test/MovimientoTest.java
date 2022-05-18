package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Compra;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Deposito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Extraccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaCredito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaDebito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Venta;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
public class MovimientoTest {

	Direccion dir;
	Cliente cte;
	CuentaLocal cta;
	Deposito dep;
	Extraccion ext;
	Compra cmp;
	Venta vnt;
	TransferenciaCredito cred;
	TransferenciaDebito debi;

	
	@Before
	public void crear() {
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		cta = new CuentaLocal(null, LocalDate.now(), 0F, 0F, 1000F, null, cte );
	}

	@Test
	public void testContructorDeposito() {
		dep = new Deposito(LocalDateTime.now(), 2000F, "deposito 1", "cajaCajero 1");
		Float monto = 2000F;
		String descripcion = "deposito 1";
		String cajero = "cajaCajero 1";
		assertEquals(monto, dep.getMonto(),0);
		assertEquals(descripcion, dep.getDescripción());
		assertEquals(cajero, dep.getCajaCajero());
	}
	
	@Test
	public void testContructorExtraccion() {
		ext = new Extraccion(LocalDateTime.now(), 500F, "extraccion1", "caja2");
		Float monto = 500F;
		String descripcion = "extraccion1";
		String cajero = "caja2";
		assertEquals(monto, ext.getMonto(),0);
		assertEquals(descripcion, ext.getDescripción());
		assertEquals(cajero, ext.getCajaCajero());
	}

	@Test
	public void testContructorCompra() {
		cmp = new Compra(LocalDateTime.now(), 500F, "compra-dolares", 205F, 5F);
		Float monto = 500F;
		String descripcion = "compra-dolares";
		Float cotizacion = 205F;
		Float comision = 5F;
		assertEquals(monto, cmp.getMonto(),0);
		assertEquals(descripcion, cmp.getDescripción());
		assertEquals(cotizacion, cmp.getCotizacion(),0);
		assertEquals(comision, cmp.getComision(),0);
	}

	@Test
	public void testContructorVenta() {
		vnt = new Venta(LocalDateTime.now(), 100F, "venta-dolares", 195F, 5F);
		Float monto = 100F;
		String descripcion = "venta-dolares";
		Float cotizacion = 195F;
		Float comision = 5F;
		assertEquals(monto, vnt.getMonto(),0);
		assertEquals(descripcion, vnt.getDescripción());
		assertEquals(cotizacion, vnt.getCotizacion(),0);
		assertEquals(comision, vnt.getComision(),0);
	}
	
	@Test
	public void testContructorCredito() {
		cred = new TransferenciaCredito(LocalDateTime.now(), 35000F, "credito-tran", cta);
		Float monto = 35000F;
		String descripcion = "credito-tran";
		assertEquals(monto, cred.getMonto(),0);
		assertEquals(descripcion, cred.getDescripción());
		assertTrue(cred.getCuentaOrigenDestino().equals(cta));
	}
	
	@Test
	public void testContructorDebito() {
		debi = new TransferenciaDebito(LocalDateTime.now(), 5000F, "debito-tran", cta);
		Float monto = 5000F;
		String descripcion = "debito-tran";
		assertEquals(monto, debi.getMonto(),0);
		assertEquals(descripcion, debi.getDescripción());
		assertTrue(debi.getCuentaOrigenDestino().equals(cta));
	}
	
}

