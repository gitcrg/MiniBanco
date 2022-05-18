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
public class Transferencia extends Movimiento{
	@ManyToOne
	@NotNull(message = "{movimiento.origenDestino}")
	@Column(updatable=false)
	private Cuenta cuentaOrigenDestino;

	public Transferencia(LocalDateTime fechayHoraDeRealizacion, float monto, String descripcion,
			Cuenta cuentaOrigenDestino) {
		super(fechayHoraDeRealizacion, monto, descripcion);
		this.cuentaOrigenDestino = cuentaOrigenDestino;
	}
	public Transferencia() {}

	public Cuenta getCuentaOrigenDestino() {
		return cuentaOrigenDestino;
	}

	public void setCuentaOrigenDestino(Cuenta cuentaOrigenDestino) {
		this.cuentaOrigenDestino = cuentaOrigenDestino;
	}
	
	
	
	
}
