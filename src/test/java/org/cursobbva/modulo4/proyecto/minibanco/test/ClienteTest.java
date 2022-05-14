package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.*;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.ClienteTitular;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.junit.Before;
import org.junit.Test;

public class ClienteTest {

	Direccion d;
	ClienteTitular c;

	@Before
	public void crearDireccion() {
		d = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
	}

	@Test
	public void testContructorCliente() {
		c = new ClienteTitular("nombre", "apellido", "telefono", "email", d);
		String nombre = "nombre";
		String apellido = "apellido";
		String telefono = "telefono";
		String email = "email";
		assertEquals(nombre, c.getNombre());
		assertEquals(apellido, c.getApellido());
		assertEquals(telefono, c.getTelefono());
		assertEquals(email, c.getEmail());
		assertTrue(c.getDireccion().equals(d));
	}
	

}
