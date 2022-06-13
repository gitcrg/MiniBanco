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
public class TransferenciaDebito extends Transferencia{
	@ManyToOne
	@NotNull(message = "{movimiento.cuentaDestino}")
	@JsonIgnore
	private Cuenta cuentaDestino;

	public TransferenciaDebito(LocalDateTime fechayHora, Double monto, String descripcion, Cuenta cuentaDestino) {
		super(fechayHora, monto, descripcion);
		this.cuentaDestino = cuentaDestino;
	}

}
