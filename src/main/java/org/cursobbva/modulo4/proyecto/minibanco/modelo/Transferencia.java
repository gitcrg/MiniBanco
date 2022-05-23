package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
public class Transferencia extends Movimiento{

	public Transferencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transferencia(LocalDateTime fechayHoraDeRealizacion, float monto, String descripcion) {
		super(fechayHoraDeRealizacion, monto, descripcion);
		// TODO Auto-generated constructor stub
	}

	
}
