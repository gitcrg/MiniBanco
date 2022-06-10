package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

import javax.persistence.Entity;

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
public class Extraccion extends DepositoExtraccion{

	public Extraccion(LocalDateTime fechayHora, Double monto, String descripcion, String cajaCajero) {
		super(fechayHora, monto, descripcion, cajaCajero);

	}
	
}
