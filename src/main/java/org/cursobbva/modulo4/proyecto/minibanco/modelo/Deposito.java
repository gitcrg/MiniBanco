package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

import javax.persistence.Entity;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
public class Deposito extends DepositoExtraccion{

	public Deposito(LocalDateTime fechayHoraDeRealizacion, float monto, String descripción, String cajaCajero) {
		super(fechayHoraDeRealizacion, monto, descripción, cajaCajero);
		// TODO Auto-generated constructor stub
	}
	public Deposito() {}

	
}
