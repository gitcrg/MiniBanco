package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
public abstract class DepositoExtraccion extends Movimiento{
	
	@NotNull(message = "{movimiento.cajaCajero}")
	@Column(updatable=false)
	private String cajaCajero;

	public DepositoExtraccion(LocalDateTime fechayHoraDeRealizacion, float monto, String descripcion,
			String cajaCajero) {
		super(fechayHoraDeRealizacion, monto, descripcion);
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
