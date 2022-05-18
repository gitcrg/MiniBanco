package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.*;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
public class DireccionTest {
	
	Direccion d1;

	@Before
	public void crearDireccion() {
		//d1 = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
	}

	@Test
	public void testContructorDireccion() {
		d1 = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		String calle = "calle1";
		String numero = "numero1";
		String departamento = "departamento1";
		String piso= "piso1";
		String ciudad = "ciudad1";
		String codigoPostal = "codigoPostal1";
		String provincia= "provincia1";
		assertEquals(calle, d1.getCalle());
		assertEquals(numero, d1.getNumero());
		assertEquals(departamento, d1.getDepartamento());
		assertEquals(piso, d1.getPiso());
		assertEquals(ciudad, d1.getCiudad());
		assertEquals(codigoPostal, d1.getCodigoPostal());
		assertEquals(provincia, d1.getProvincia());
	}


}
