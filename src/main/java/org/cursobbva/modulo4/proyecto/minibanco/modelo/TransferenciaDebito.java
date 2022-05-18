package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

import javax.persistence.Entity;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
public class TransferenciaDebito extends Transferencia{

	public TransferenciaDebito(LocalDateTime fechayHoraDeRealizacion, float monto, String descripci�n,
			Cuenta cuentaOrigenDestino) {
		super(fechayHoraDeRealizacion, monto, descripci�n, cuentaOrigenDestino);
		// TODO Auto-generated constructor stub
	}
	public TransferenciaDebito() {}
	
	

}
