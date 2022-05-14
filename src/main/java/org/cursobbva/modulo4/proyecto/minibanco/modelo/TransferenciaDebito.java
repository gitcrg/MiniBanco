package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

public class TransferenciaDebito extends Transferencia{

	public TransferenciaDebito(LocalDateTime fechayHoraDeRealizacion, float monto, String descripción,
			Cuenta cuentaOrigenDestino) {
		super(fechayHoraDeRealizacion, monto, descripción, cuentaOrigenDestino);
		// TODO Auto-generated constructor stub
	}

	
	

}
