package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

import javax.persistence.Entity;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
public class TransferenciaCredito extends Transferencia{

	public TransferenciaCredito(LocalDateTime fechayHoraDeRealizacion, float monto, String descripción,
			Cuenta cuentaOrigenDestino) {
		super(fechayHoraDeRealizacion, monto, descripción, cuentaOrigenDestino);
		// TODO Auto-generated constructor stub
	}
	public TransferenciaCredito() {}
	

}
