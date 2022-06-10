package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
