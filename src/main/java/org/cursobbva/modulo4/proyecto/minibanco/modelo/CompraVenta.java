package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

public abstract class CompraVenta extends Movimiento{
	
	private float cotizacion;
	
	private float comision;

	public CompraVenta(LocalDateTime fechayHoraDeRealizacion, float monto, String descripción, float cotizacion,
			float comision) {
		super(fechayHoraDeRealizacion, monto, descripción);
		this.cotizacion = cotizacion;
		this.comision = comision;
	}

	public float getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(float cotizacion) {
		this.cotizacion = cotizacion;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}
	
	

}
