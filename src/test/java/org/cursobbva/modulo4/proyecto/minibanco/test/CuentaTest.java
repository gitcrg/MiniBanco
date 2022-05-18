package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
public class CuentaTest {

	Direccion dir;
	Cliente cte;
	CuentaLocal cta;

	@Before
	public void crearDireccion() {
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
	}

	@Test
	public void testContructorCuenta() {
		cta = new CuentaLocal(1234L, LocalDate.now(), 0F, 0F, 1000F, null, cte );
		long numero = 1234L;
		LocalDate fechacreacion = LocalDate.now();
		Float saldoInicial = 0F;
		Float saldoActual = 0F;
		Float descubierto = 1000F;
		LocalDate fechaCierre = null;
		assertEquals(numero, cta.getNumero(),0);
		assertEquals(fechacreacion, cta.getFechaDeCreacion());
		assertEquals(saldoInicial, cta.getSaldoInicial(),0);
		assertEquals(saldoActual, cta.getSaldoActual(),0);
		assertEquals(descubierto, cta.getDescubiertoAcordado(),0);
		assertEquals(fechaCierre, cta.getFechaDeCierre());
		assertTrue(cta.getTitular().equals(cte));
	}
	

}
