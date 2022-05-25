package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
public class TransferenciaCredito extends Transferencia{
	@ManyToOne
	@NotNull(message = "{movimiento.cuentaOrigen}")
	private Cuenta cuentaOrigen;

	public TransferenciaCredito(LocalDateTime fechayHoraDeRealizacion, float monto, String descripcion,	Cuenta cuentaOrigen) {
		super(fechayHoraDeRealizacion, monto, descripcion);
		this.cuentaOrigen = cuentaOrigen;
	}

	public TransferenciaCredito() {}

	public Cuenta getCuentaOrigen() {
		return cuentaOrigen;
	}

	public void setCuentaOrigen(Cuenta cuentaOrigen) {
		this.cuentaOrigen = cuentaOrigen;
	}
	
}
