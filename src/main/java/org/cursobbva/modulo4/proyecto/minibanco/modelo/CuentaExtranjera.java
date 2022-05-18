package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
/**
 * 
 * @author Cristian Gutierrez
 *
 */
@Entity
public class CuentaExtranjera extends Cuenta{
	
	@Enumerated(EnumType.STRING)
	private TipoMoneda moneda;

	public CuentaExtranjera(LocalDate fechaDeDreación, float saldoInicial, float saldoActual,
			float descubiertoAcordado, LocalDate fechaDeCierre, Cliente titular, TipoMoneda moneda) {
		super(fechaDeDreación, saldoInicial, saldoActual, descubiertoAcordado, fechaDeCierre, titular);
		this.moneda = moneda;
	}
	public CuentaExtranjera() {}

	public TipoMoneda getMoneda() {
		return moneda;
	}

	public void setMoneda(TipoMoneda moneda) {
		this.moneda = moneda;
	}

	

}
