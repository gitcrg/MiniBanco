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
public class TransferenciaDebito extends Transferencia{
	@ManyToOne
	@NotNull(message = "{movimiento.cuentaDestino}")
	private Cuenta cuentaDestino;

	public TransferenciaDebito(LocalDateTime fechayHoraDeRealizacion, float monto, String descripcion, Cuenta cuentaDestino) {
		super(fechayHoraDeRealizacion, monto, descripcion);
		this.cuentaDestino = cuentaDestino;
	}

	public TransferenciaDebito() {}

	public Cuenta getCuentaDestino() {
		return cuentaDestino;
	}

	public void setCuentaDestino(Cuenta cuentaDestino) {
		this.cuentaDestino = cuentaDestino;
	}
	
	
}
