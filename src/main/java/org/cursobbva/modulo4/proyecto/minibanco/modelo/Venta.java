package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
public class Venta extends CompraVenta{

	public Venta(LocalDateTime fechayHoraDeRealizacion, float monto, String descripci�n, float cotizacion,
			float comision) {
		super(fechayHoraDeRealizacion, monto, descripci�n, cotizacion, comision);
		// TODO Auto-generated constructor stub
	}
	public Venta() {}
	

}
