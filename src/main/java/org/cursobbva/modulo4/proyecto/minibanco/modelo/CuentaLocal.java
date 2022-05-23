package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Entity
public class CuentaLocal extends Cuenta{

	public CuentaLocal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CuentaLocal(LocalDate fechaDeCreacion, float saldoInicial, float saldoActual, float descubiertoAcordado,
			LocalDate fechaDeCierre, Cliente titular) {
		super(fechaDeCreacion, saldoInicial, saldoActual, descubiertoAcordado, fechaDeCierre, titular);
		// TODO Auto-generated constructor stub
	}




}
