package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

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
public class Compra extends CompraVenta{

	public Compra(LocalDateTime fechayHoraDeRealizacion, Double monto, String descripcion, Double cotizacion, Double comision) {
		super(fechayHoraDeRealizacion, monto, descripcion, cotizacion, comision);

	}

}
