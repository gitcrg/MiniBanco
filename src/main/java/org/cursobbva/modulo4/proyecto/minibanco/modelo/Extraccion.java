package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

import javax.persistence.Entity;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
public class Extraccion extends DepositoExtraccion{

	public Extraccion(LocalDateTime fechayHoraDeRealizacion, float monto, String descripcion, String cajaCajero) {
		super(fechayHoraDeRealizacion, monto, descripcion, cajaCajero);
		// TODO Auto-generated constructor stub
	}
	public Extraccion() {}

	
}
