package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

import javax.persistence.Entity;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
public abstract class DepositoExtraccion extends Movimiento{
	
	private String cajaCajero;

	public DepositoExtraccion(LocalDateTime fechayHoraDeRealizacion, float monto, String descripción,
			String cajaCajero) {
		super(fechayHoraDeRealizacion, monto, descripción);
		this.cajaCajero = cajaCajero;
	}
	public DepositoExtraccion() {}

	public String getCajaCajero() {
		return cajaCajero;
	}

	public void setCajaCajero(String cajaCajero) {
		this.cajaCajero = cajaCajero;
	}
	

	
}
