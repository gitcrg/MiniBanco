package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Deposito extends DepositoExtraccion{

	public Deposito(LocalDateTime fechayHora, Double monto, String descripcion, String cajaCajero) {
		super(fechayHora, monto, descripcion, cajaCajero);

	}
	
}
