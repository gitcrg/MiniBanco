package org.cursobbva.modulo4.proyecto.minibanco.uso;

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

public class UsoMiniBancoValidaciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		System.out.println("Inicio Validacion Direccion...");
		Direccion dir = new Direccion("", "", "", "", "", "", "");
		
		Set<ConstraintViolation<Direccion>> violationsDir = validator.validate(dir);
		if (violationsDir.isEmpty()) {
			System.out.println("No hay errores");
		} else { 
			for (ConstraintViolation<Direccion> violation : violationsDir) {
				System.out.println(violation.getMessage()); 
			}
		}
		System.out.println("Fin Validacion Direccion...");
		
		System.out.println("Inicio Validacion Cliente...");
		
		Cliente cte = new Cliente("", "", "", "", null);
		
		Set<ConstraintViolation<Cliente>> violationsCte = validator.validate(cte);
		if (violationsCte.isEmpty()) {
			System.out.println("No hay errores");
		} else { 
			for (ConstraintViolation<Cliente> violation : violationsCte) {
				System.out.println(violation.getMessage()); 
			}
		}
		
		System.out.println("Fin Validacion Cliente...");
		
		System.out.println("Inicio Validacion Cuenta...");
		
		Cuenta cta = new CuentaLocal(null, -1F, -1F, -1F, null, null);
		
		Set<ConstraintViolation<Cuenta>> violationsCta = validator.validate(cta);
		if (violationsCta.isEmpty()) {
			System.out.println("No hay errores");
		} else { 
			for (ConstraintViolation<Cuenta> violation : violationsCta) {
				System.out.println(violation.getMessage()); 
			}
		}
		
		System.out.println("Fin Validacion Cuenta...");

		System.out.println("Inicio Validacion Movimiento...");
		
		Movimiento debi = new TransferenciaDebito(null, -1F, "", null);
		
		Set<ConstraintViolation<Movimiento>> violationsMov = validator.validate(debi);
		if (violationsMov.isEmpty()) {
			System.out.println("No hay errores");
		} else { 
			for (ConstraintViolation<Movimiento> violation : violationsMov) {
				System.out.println(violation.getMessage()); 
			}
		}
		
		System.out.println("Fin Validacion Movimiento...");

		System.out.println("Inicio Validacion Movimiento...");
		
		Movimiento cred = new TransferenciaCredito(null, -1F, "", null);
		
		Set<ConstraintViolation<Movimiento>> violationsMov2 = validator.validate(cred);
		if (violationsMov2.isEmpty()) {
			System.out.println("No hay errores");
		} else { 
			for (ConstraintViolation<Movimiento> violation : violationsMov2) {
				System.out.println(violation.getMessage()); 
			}
		}
		
		System.out.println("Fin Validacion Movimiento...");

		

	}

}
