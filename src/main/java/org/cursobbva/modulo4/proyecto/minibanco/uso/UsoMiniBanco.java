package org.cursobbva.modulo4.proyecto.minibanco.uso;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.cursobbva.modulo4.proyecto.minibanco.modelo.ClienteCoTitular;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.ClienteTitular;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Compra;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaExtranjera;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.CuentaLocal;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Direccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.Extraccion;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TransferenciaCredito;

public class UsoMiniBanco {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	
		System.out.println("Inicio...");
		
		Direccion d1 = new Direccion("calle1", "numero1", "departamento1", "piso1", "ciudad1", "codigoPostal1", "provincia1");
		Direccion d2 = new Direccion("calle2", "numero2", "departamento2", "piso2", "ciudad2", "codigoPostal2", "provincia2");
		
		ClienteTitular ct1 = new ClienteTitular("nombre", "apellido", "telefono", "email", d1);
		ClienteCoTitular cc1 = new ClienteCoTitular("nombre", "apellido", "telefono", "email", d2);
	
		CuentaLocal cta1 = new CuentaLocal(1L, LocalDate.now(), 0F, 0F, 1000F, null, ct1);
		CuentaExtranjera cta2 = new CuentaExtranjera(1L, LocalDate.now(), 0F, 0F, 1000F, null, ct1, TipoMoneda.DOLAR);
		cta2.agregarCotitular(cc1);
		
		TransferenciaCredito tr1 = new TransferenciaCredito(LocalDateTime.now(), 10F, "Credito", cta1);
		Compra cmvn1 = new Compra(LocalDateTime.now(), 50F, "compra dolar", 200F, 0F);
		Extraccion ext1 = new Extraccion(LocalDateTime.now(),300F, "extraccion", "cajero1");
		
		cta1.agregarMovimiento(tr1);
		cta1.agregarMovimiento(ext1);
		cta2.agregarMovimiento(cmvn1);
		
		System.out.println("Fin...");
		
	}

}
