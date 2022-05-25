package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
public class Venta extends CompraVenta{

	public Venta(LocalDateTime fechayHoraDeRealizacion, float monto, String descripcion, float cotizacion,
			float comision) {
		super(fechayHoraDeRealizacion, monto, descripcion, cotizacion, comision);
		// TODO Auto-generated constructor stub
	}
	public Venta() {}
	

}
