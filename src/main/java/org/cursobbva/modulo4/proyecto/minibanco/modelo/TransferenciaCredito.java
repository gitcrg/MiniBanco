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

	public TransferenciaCredito(LocalDateTime fechayHoraDeRealizacion, float monto, String descripci�n,
			Cuenta cuentaOrigenDestino) {
		super(fechayHoraDeRealizacion, monto, descripci�n, cuentaOrigenDestino);
		// TODO Auto-generated constructor stub
	}
	public TransferenciaCredito() {}
	

}
