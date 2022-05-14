package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

public class Transferencia extends Movimiento{
	
	private Cuenta cuentaOrigenDestino;


	public Transferencia(LocalDateTime fechayHoraDeRealizacion, float monto, String descripci�n,
			Cuenta cuentaOrigenDestino) {
		super(fechayHoraDeRealizacion, monto, descripci�n);
		this.cuentaOrigenDestino = cuentaOrigenDestino;
	}

	public Cuenta getCuentaOrigenDestino() {
		return cuentaOrigenDestino;
	}

	public void setCuentaOrigenDestino(Cuenta cuentaOrigenDestino) {
		this.cuentaOrigenDestino = cuentaOrigenDestino;
	}
	
	
	
	
}
