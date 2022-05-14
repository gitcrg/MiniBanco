package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

public abstract class DepositoExtraccion extends Movimiento{
	
	private String cajaCajero;

	public DepositoExtraccion(LocalDateTime fechayHoraDeRealizacion, float monto, String descripci�n,
			String cajaCajero) {
		super(fechayHoraDeRealizacion, monto, descripci�n);
		this.cajaCajero = cajaCajero;
	}

	public String getCajaCajero() {
		return cajaCajero;
	}

	public void setCajaCajero(String cajaCajero) {
		this.cajaCajero = cajaCajero;
	}
	

	
}
