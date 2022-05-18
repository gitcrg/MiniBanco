package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
public class CuentaLocal extends Cuenta{

	public CuentaLocal(LocalDate fechaDeDreacion, float saldoInicial, float saldoActual,
			float descubiertoAcordado, LocalDate fechaDeCierre, Cliente titular) {
		super(fechaDeDreacion, saldoInicial, saldoActual, descubiertoAcordado, fechaDeCierre, titular);
		// TODO Auto-generated constructor stub
	}
	public CuentaLocal() {}

}
