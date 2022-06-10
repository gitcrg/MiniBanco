package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
@Data
@NoArgsConstructor
public abstract class DepositoExtraccion extends Movimiento{
	
	@NotNull(message = "{movimiento.cajaCajero}")
	@Column(updatable=false)
	private String cajaCajero;

	public DepositoExtraccion(LocalDateTime fechayHora, Double monto, String descripcion, String cajaCajero) {
		super(fechayHora, monto, descripcion);
		this.cajaCajero = cajaCajero;
	}
	
}
