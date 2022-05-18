package org.cursobbva.modulo4.proyecto.minibanco.modelo;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
public class Transferencia extends Movimiento{
	@ManyToOne
	private Cuenta cuentaOrigenDestino;

	public Transferencia(LocalDateTime fechayHoraDeRealizacion, float monto, String descripción,
			Cuenta cuentaOrigenDestino) {
		super(fechayHoraDeRealizacion, monto, descripción);
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
