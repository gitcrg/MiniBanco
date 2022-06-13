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
public class Transferencia extends Movimiento{

	public Transferencia(LocalDateTime fechayHora, Double monto, String descripcion) {
		super(fechayHora, monto, descripcion);
	}
	
}
