package org.cursobbva.modulo4.proyecto.minibanco.test;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
public class DireccionTest {
	
	Direccion dir;
	ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();
	
	@Before
	public void crearDireccion() {
		//dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudadir", "codigoPostal1", "provincia1");
	}

	@Test
	public void testContructorDireccionOk() {
		dir = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudadir", "codigoPostal1", "provincia1");
		String calle = "calle1";
		String numero = "numero1";
		String departamento = "departamento1";
		String piso= "piso1";
		String ciudad = "ciudadir";
		String codigoPostal = "codigoPostal1";
		String provincia= "provincia1";
		assertEquals(calle, dir.getCalle());
		assertEquals(numero, dir.getNumero());
		assertEquals(departamento, dir.getDepartamento());
		assertEquals(piso, dir.getPiso());
		assertEquals(ciudad, dir.getCiudad());
		assertEquals(codigoPostal, dir.getCodigoPostal());
		assertEquals(provincia, dir.getProvincia());
	}

	@Test
	public void testValidacionCamposObligatorios() {
		String calle = "";
		String numero = "";
		String departamento = "";
		String piso= "";
		String ciudad = "";
		String codigoPostal = "";
		String provincia= "";
		
		dir = new Direccion(calle, numero, departamento, piso, ciudad, codigoPostal, provincia);

		Set<ConstraintViolation<Direccion>> violations = validator.validate(dir);
		assertTrue(!violations.isEmpty());
		assertEquals(5,violations.size());
		
	}

}
