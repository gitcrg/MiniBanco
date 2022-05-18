package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.*;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
public class ClienteTest {

	Direccion dir;
	Cliente cte;

	@Before
	public void crearDireccion() {
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
	}

	@Test
	public void testContructorCliente() {
		cte = new Cliente("nombre", "apellido", "telefono", "email", dir);
		String nombre = "nombre";
		String apellido = "apellido";
		String telefono = "telefono";
		String email = "email";
		assertEquals(nombre, cte.getNombre());
		assertEquals(apellido, cte.getApellido());
		assertEquals(telefono, cte.getTelefono());
		assertEquals(email, cte.getEmail());
		assertTrue(cte.getDireccion().equals(dir));
	}
	

}
