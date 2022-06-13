package org.cursobbva.modulo4.proyecto.minibanco.main;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cuenta;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Movimiento;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaCredito;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaDebito;
/**
 * Main para Validaciones
 * @author Cristian Gutierrez
 *
 */
public class UsoMiniBancoValidaciones {

	public static void main(String[] args) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		System.out.println("---------- INICIO VALIDACION DIRECCION ----------");
		Direccion dir = new Direccion("", "", "", "", "", "", "");
		
		Set<ConstraintViolation<Direccion>> violationsDir = validator.validate(dir);
		if (violationsDir.isEmpty()) {
			System.out.println("No hay errores");
		} else { 
			for (ConstraintViolation<Direccion> violation : violationsDir) {
				System.out.println(violation.getMessage()); 
			}
		}
		System.out.println("---------- FINAL VALIDACION DIRECCION ----------");
		
		System.out.println("---------- INICIO VALIDACION CLIENTE ----------");
		
		Cliente cte = new Cliente("name", "ape", "", "", null);
		
		Set<ConstraintViolation<Cliente>> violationsCte = validator.validate(cte);
		if (violationsCte.isEmpty()) {
			System.out.println("No hay errores");
		} else { 
			for (ConstraintViolation<Cliente> violation : violationsCte) {
				System.out.println(violation.getMessage()); 
			}
		}
		
		System.out.println("---------- FINAL VALIDACION CLIENTE ----------");
		
		System.out.println("---------- INICIO VALIDACION CUENTA ----------");
		
		Cuenta cta = new CuentaLocal(null, -1D, -1D, -1D, null, null);
		
		Set<ConstraintViolation<Cuenta>> violationsCta = validator.validate(cta);
		if (violationsCta.isEmpty()) {
			System.out.println("No hay errores");
		} else { 
			for (ConstraintViolation<Cuenta> violation : violationsCta) {
				System.out.println(violation.getMessage()); 
			}
		}
		
		System.out.println("---------- FINAL VALIDACION CUENTA ----------");

		System.out.println("---------- INICIO VALIDACION MOVIMIENTO ----------");
		
		Movimiento debi = new TransferenciaDebito(null, 0D, "", null);
		
		Set<ConstraintViolation<Movimiento>> violationsMov = validator.validate(debi);
		if (violationsMov.isEmpty()) {
			System.out.println("No hay errores");
		} else { 
			for (ConstraintViolation<Movimiento> violation : violationsMov) {
				System.out.println(violation.getMessage()); 
			}
		}
		
		System.out.println("---------- FINAL VALIDACION MOVIMIENTO ----------");

		System.out.println("---------- INICIO VALIDACION MOVIMIENTO ----------");
		
		Movimiento cred = new TransferenciaCredito(null, 0D, "", null);
		
		Set<ConstraintViolation<Movimiento>> violationsMov2 = validator.validate(cred);
		if (violationsMov2.isEmpty()) {
			System.out.println("No hay errores");
		} else { 
			for (ConstraintViolation<Movimiento> violation : violationsMov2) {
				System.out.println(violation.getMessage()); 
			}
		}
		
		System.out.println("---------- FINAL VALIDACION MOVIMIENTO ----------");

		

	}

}
