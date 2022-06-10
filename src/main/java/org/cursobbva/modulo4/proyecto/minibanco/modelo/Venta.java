package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Venta extends CompraVenta{

	public Venta(LocalDateTime fechayHoraDeRealizacion, Double monto, String descripcion, Double cotizacion, Double comision) {
		super(fechayHoraDeRealizacion, monto, descripcion, cotizacion, comision);
	}

}
