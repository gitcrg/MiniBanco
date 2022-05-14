package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

public class Transferencia extends Movimiento{
	
	private Cuenta cuentaOrigenDestino;


	public Transferencia(LocalDateTime fechayHoraDeRealizacion, float monto, String descripción,
			Cuenta cuentaOrigenDestino) {
		super(fechayHoraDeRealizacion, monto, descripción);
		this.cuentaOrigenDestino = cuentaOrigenDestino;
	}

	public Cuenta getCuentaOrigenDestino() {
		return cuentaOrigenDestino;
	}

	public void setCuentaOrigenDestino(Cuenta cuentaOrigenDestino) {
		this.cuentaOrigenDestino = cuentaOrigenDestino;
	}
	
	
	
	
}
