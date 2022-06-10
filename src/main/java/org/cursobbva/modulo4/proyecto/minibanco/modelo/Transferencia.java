package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

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
public class Transferencia extends Movimiento{

	public Transferencia(LocalDateTime fechayHora, Double monto, String descripcion) {
		super(fechayHora, monto, descripcion);
	}
	
}
