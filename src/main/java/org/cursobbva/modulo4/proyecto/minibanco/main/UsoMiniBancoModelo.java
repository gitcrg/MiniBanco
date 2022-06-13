package org.cursobbva.modulo4.proyecto.minibanco.main;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Compra;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Extraccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaCredito;

/**
 * Main para usar el modelo de clases
 * @author Cristian Gutierrez
 *
 */

public class UsoMiniBancoModelo {
	
	public static void main(String[] args) {
		
		Direccion dir1 = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		Direccion dir2 = new Direccion("calle2", "numero2", "departamento2", "piso2", "ciudad2", "codigoPostal2", "provincia2");
		Direccion dir3 = new Direccion("calle3", "numero3", "departamento3", "piso3", "ciudad3", "codigoPostal3", "provincia3");
		
		Cliente cte1 = new Cliente("nombrecte1", "apellido1", "telefono1", "email1@email.com", dir1);
		Cliente cte2 = new Cliente("nombrecte2", "apellido2", "telefono2", "email2@email.com", dir2);
		Cliente cte3 = new Cliente("nombrecte3", "apellido3", "telefono3", "email3@email.com", dir3);
				
		CuentaLocal ctaLoc1 = new CuentaLocal(LocalDate.now(), 0D, 0D, 1000D, LocalDate.now(), cte1);
		ctaLoc1.agregarCotitular(cte1);//cte1.agregarCuentaCoTitular(ctaLoc1);
		ctaLoc1.agregarCotitular(cte2);//cte2.agregarCuentaCoTitular(ctaLoc1);
		ctaLoc1.agregarCotitular(cte3);//cte3.agregarCuentaCoTitular(ctaLoc1);
		
		TransferenciaCredito tranCred1 = new TransferenciaCredito(LocalDateTime.now(), 10D, "Credito", ctaLoc1);
		Compra cmpr1 = new Compra(LocalDateTime.now(), 50D, "compra dolar", 200D, 0D);
		Extraccion extra1 = new Extraccion(LocalDateTime.now(),300D, "extraccion", "cajero1");
		
		ctaLoc1.agregarMovimiento(tranCred1);//tranCred1.setCuenta(ctaLoc1);
		ctaLoc1.agregarMovimiento(extra1);//extra1.setCuenta(ctaLoc1);
		ctaLoc1.agregarMovimiento(cmpr1);

	}

}
