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
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

	@BeforeEach
	public void crearDireccion() {
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
	}

	@Test
	public void testContructorClienteOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);
		String nombre = "nombre";
		String apellido = "apellido";
		String telefono = "telefono";
		String email = "email@email.com";
		assertEquals(nombre, cte.getNombre());
		assertEquals(apellido, cte.getApellido());
		assertEquals(telefono, cte.getTelefono());
		assertEquals(email, cte.getEmail());
		assertTrue(cte.getDireccion().equals(dir));
	}
	
	@Test
	public void testClienteCambioDatosOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);
		String nombre = "nombre";
		String apellido = "apellido";
		String telefono = "telefono";
		String email = "email@email.com";
		assertEquals(nombre, cte.getNombre());
		assertEquals(apellido, cte.getApellido());
		assertEquals(telefono, cte.getTelefono());
		assertEquals(email, cte.getEmail());
		assertTrue(cte.getDireccion().equals(dir));
		cte.setNombre("nuevoNombre");
		cte.setApellido("nuevoApellido");
		cte.setTelefono("nuevoTelefono");
		cte.setEmail("nuevoEmail@email.com");
		assertEquals("nuevoNombre", cte.getNombre());
		assertEquals("nuevoApellido", cte.getApellido());
		assertEquals("nuevoTelefono", cte.getTelefono());
		assertEquals("nuevoEmail@email.com", cte.getEmail());
		
	}

	@Test
	public void testClienteCambioDireccionOk() {
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);
		assertEquals("calle1", cte.getDireccion().getCalle());
		assertEquals("numero1", cte.getDireccion().getNumero());
		
		Direccion nuevadir = new Direccion("otraCalle", "nuevoNumero", "", "", "ciudad1", "codigoPostal1", "provincia1");
		cte.setDireccion(nuevadir);;
		assertEquals("otraCalle", cte.getDireccion().getCalle());
		assertEquals("nuevoNumero", cte.getDireccion().getNumero());
		
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
		assertEquals(4,violations.size());
		
	}

	@Test
	public void testAgregarCuentaCotitular() {
		
		Cuenta cta1 = mock(Cuenta.class);
		Cuenta cta2 = mock(Cuenta.class);
		Cuenta cta3 = mock(Cuenta.class);
		Cuenta cta4 = mock(Cuenta.class);
		Cuenta cta5 = mock(Cuenta.class);
		
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);

		cte.agregarCuentaCoTitular(cta1);
		cte.agregarCuentaCoTitular(cta2);
		cte.agregarCuentaCoTitular(cta3);
		cte.agregarCuentaCoTitular(cta4);
		cte.agregarCuentaCoTitular(cta5);
		
		assertEquals(5, cte.getCuentasCoTitular().size());
	}

	@Test
	public void testAgregarCuentaCotitularDuplicado() {
		Cuenta cta1 = mock(Cuenta.class);
		Cuenta cta2 = mock(Cuenta.class);
		Cuenta cta3 = mock(Cuenta.class);
		Cuenta cta4 = mock(Cuenta.class);

		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);

		try {
			cte.agregarCuentaCoTitular(cta1);
			cte.agregarCuentaCoTitular(cta2);
			cte.agregarCuentaCoTitular(cta3);
			cte.agregarCuentaCoTitular(cta2);
		} catch (IllegalArgumentException e) {
			assertEquals("Cliente ya es cotitular de la cuenta", e.getMessage());
		}

	}
	
	@Test
	public void testQuitarCuentaCotitular() {
		
		Cuenta cta1 = mock(Cuenta.class);
		Cuenta cta2 = mock(Cuenta.class);
		Cuenta cta3 = mock(Cuenta.class);
		Cuenta cta4 = mock(Cuenta.class);
		Cuenta cta5 = mock(Cuenta.class);
		
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);

		cte.agregarCuentaCoTitular(cta1);
		cte.agregarCuentaCoTitular(cta2);
		cte.agregarCuentaCoTitular(cta3);
		cte.agregarCuentaCoTitular(cta4);
		cte.agregarCuentaCoTitular(cta5);
		
		assertEquals(5, cte.getCuentasCoTitular().size());
		
		cte.quitarCuentaCoTitular(cta4);
		cte.quitarCuentaCoTitular(cta5);
		assertEquals(3, cte.getCuentasCoTitular().size());
		
	}

	@Test
	public void testQuitarCuentaCotitularInexistente() {
		Cuenta cta1 = mock(Cuenta.class);
		Cuenta cta2 = mock(Cuenta.class);
		Cuenta cta3 = mock(Cuenta.class);
		Cuenta cta4 = mock(Cuenta.class);
		Cuenta cta5 = mock(Cuenta.class);

		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);
		cte.agregarCuentaCoTitular(cta1);
		cte.agregarCuentaCoTitular(cta2);
		cte.agregarCuentaCoTitular(cta3);
		cte.agregarCuentaCoTitular(cta4);

		
		assertEquals(4, cte.getCuentasCoTitular().size());
		
		
		try {
			cte.quitarCuentaCoTitular(cta5);;

		} catch (IllegalArgumentException e) {
			assertEquals("Cliente no es cotitular de la cuenta", e.getMessage());
		}

	}

	@Test
	public void testCuentaDelCliente() {
		Cuenta cta1 = mock(Cuenta.class);
		Cuenta cta2 = mock(Cuenta.class);
		
		when(cta1.getNumero()).thenReturn(1L);
		when(cta2.getNumero()).thenReturn(2L);
		
		cte = new Cliente("nombre", "apellido", "telefono", "email@email.com", dir);
		cte.agregarCuentaCoTitular(cta1);
		
		assertTrue(cte.cuentaDelCliente(cta1));
		assertTrue(!cte.cuentaDelCliente(cta2));

	}


}
