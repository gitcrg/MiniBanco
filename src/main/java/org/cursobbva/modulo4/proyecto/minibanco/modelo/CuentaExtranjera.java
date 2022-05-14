package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;

public class CuentaExtranjera extends Cuenta{
	
	private TipoMoneda moneda;

	public CuentaExtranjera(Long numero, LocalDate fechaDeDreación, float saldoInicial, float saldoActual,
			float descubiertoAcordado, LocalDate fechaDeCierre, ClienteTitular titular, TipoMoneda moneda) {
		super(numero, fechaDeDreación, saldoInicial, saldoActual, descubiertoAcordado, fechaDeCierre, titular);
		this.moneda = moneda;
	}

	public TipoMoneda getMoneda() {
		return moneda;
	}

	public void setMoneda(TipoMoneda moneda) {
		this.moneda = moneda;
	}

	

}
