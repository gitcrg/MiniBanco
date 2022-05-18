package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();

	@Before
	public void crearDireccion() {
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
	}

	@Test
	public void testContructorClienteOk() {
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
	
	@Test
	public void testValidacionCamposObligatorios() {
		String nombre = "";
		String apellido = "";
		String telefono = "";
		String email = "";
		
		cte = new Cliente(nombre, apellido, telefono, email, null);

		Set<ConstraintViolation<Cliente>> violations = validator.validate(cte);
		assertTrue(!violations.isEmpty());
		assertEquals(3,violations.size());
		
	}


}
