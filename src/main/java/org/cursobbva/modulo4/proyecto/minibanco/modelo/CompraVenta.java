package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Positive;

/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
public abstract class CompraVenta extends Movimiento{
	@Positive(message = "{movimiento.cotizacion}")
	@Column(updatable=false)
	private float cotizacion;
	
	private float comision;

	public CompraVenta(LocalDateTime fechayHoraDeRealizacion, float monto, String descripcion, float cotizacion,
			float comision) {
		super(fechayHoraDeRealizacion, monto, descripcion);
		this.cotizacion = cotizacion;
		this.comision = comision;
	}
	public CompraVenta() {}

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
