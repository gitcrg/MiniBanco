package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class Compra extends CompraVenta{

	public Compra(LocalDateTime fechayHoraDeRealizacion, Double monto, String descripcion, Double cotizacion, Double comision) {
		super(fechayHoraDeRealizacion, monto, descripcion, cotizacion, comision);

	}

}
