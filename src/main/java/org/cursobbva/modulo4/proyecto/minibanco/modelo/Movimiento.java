package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

public abstract class Movimiento {

	private LocalDateTime fechayHoraDeRealizacion;
	private float monto;
	private String descripci�n;
	
	public Movimiento(LocalDateTime fechayHoraDeRealizacion, float monto, String descripci�n) {
		super();
		this.fechayHoraDeRealizacion = fechayHoraDeRealizacion;
		this.monto = monto;
		this.descripci�n = descripci�n;
	}

	public LocalDateTime getFechayHoraDeRealizacion() {
		return fechayHoraDeRealizacion;
	}

	public void setFechayHoraDeRealizacion(LocalDateTime fechayHoraDeRealizacion) {
		this.fechayHoraDeRealizacion = fechayHoraDeRealizacion;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}

	public String getDescripci�n() {
		return descripci�n;
	}

	public void setDescripci�n(String descripci�n) {
		this.descripci�n = descripci�n;
	}
	
	
	
}
