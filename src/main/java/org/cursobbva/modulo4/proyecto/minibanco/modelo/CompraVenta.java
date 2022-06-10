package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
@Data
@NoArgsConstructor
public abstract class CompraVenta extends Movimiento{
	@Positive(message = "{movimiento.cotizacion}")
	@Column(updatable=false)
	private Double cotizacion;
	@Column(updatable=false)
	private Double comision;

	public CompraVenta(LocalDateTime fechayHora, Double monto, String descripcion, Double cotizacion, Double comision) {
		super(fechayHora, monto, descripcion);
		this.cotizacion = cotizacion;
		this.comision = comision;
	}

}
