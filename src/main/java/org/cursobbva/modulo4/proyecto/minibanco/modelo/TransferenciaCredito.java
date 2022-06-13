package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class TransferenciaCredito extends Transferencia{
	@ManyToOne
	@NotNull(message = "{movimiento.cuentaOrigen}")
	@JsonIgnore
	private Cuenta cuentaOrigen;

	public TransferenciaCredito(LocalDateTime fechayHora, Double monto, String descripcion,	Cuenta cuentaOrigen) {
		super(fechayHora, monto, descripcion);
		this.cuentaOrigen = cuentaOrigen;
	}

}
