package org.cursobbva.modulo4.proyecto.minibanco.uso;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.Cliente;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Compra;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Extraccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaCredito;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
public class UsoMiniBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		System.out.println("Inicio...");
		
		Direccion dir1 = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		Direccion dir2 = new Direccion("calle2", "numero2", "departamento2", "piso2", "ciudad2", "codigoPostal2", "provincia2");
		Direccion dir3 = new Direccion("calle3", "numero3", "departamento3", "piso3", "ciudad3", "codigoPostal3", "provincia3");
		
		Cliente cte1 = new Cliente("nombrecte1", "apellido", "telefono", "email", dir1);
		Cliente cte2 = new Cliente("nombrecte2", "apellido", "telefono", "email", dir2);
		Cliente cte3 = new Cliente("nombrecte3", "apellido", "telefono", "email", dir3);
	
		CuentaLocal ctaLoc1 = new CuentaLocal(1L, LocalDate.now(), 0F, 0F, 1000F, null, cte1);
		CuentaExtranjera ctaExt2 = new CuentaExtranjera(1L, LocalDate.now(), 0F, 0F, 1000F, null, cte1, TipoMoneda.DOLAR);
		ctaExt2.agregarCotitular(cte2);
		ctaExt2.agregarCotitular(cte3);
		
		TransferenciaCredito tranCred1 = new TransferenciaCredito(LocalDateTime.now(), 10F, "Credito", ctaLoc1);
		Compra cmpr1 = new Compra(LocalDateTime.now(), 50F, "compra dolar", 200F, 0F);
		Extraccion extra1 = new Extraccion(LocalDateTime.now(),300F, "extraccion", "cajero1");
		
		ctaLoc1.agregarMovimiento(tranCred1);
		ctaLoc1.agregarMovimiento(extra1);
		ctaExt2.agregarMovimiento(cmpr1);
		
		System.out.println("Fin...");
		
	}

}
