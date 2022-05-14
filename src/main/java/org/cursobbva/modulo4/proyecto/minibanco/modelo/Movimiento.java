package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

public abstract class Movimiento {

	private LocalDateTime fechayHoraDeRealizacion;
	private float monto;
	private String descripción;
	
	public Movimiento(LocalDateTime fechayHoraDeRealizacion, float monto, String descripción) {
		super();
		this.fechayHoraDeRealizacion = fechayHoraDeRealizacion;
		this.monto = monto;
		this.descripción = descripción;
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

	public String getDescripción() {
		return descripción;
	}

	public void setDescripción(String descripción) {
		this.descripción = descripción;
	}
	
	
	
}
