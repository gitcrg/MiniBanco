package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;

public class CuentaLocal extends Cuenta{

	public CuentaLocal(Long numero, LocalDate fechaDeDreación, float saldoInicial, float saldoActual,
			float descubiertoAcordado, LocalDate fechaDeCierre, ClienteTitular titular) {
		super(numero, fechaDeDreación, saldoInicial, saldoActual, descubiertoAcordado, fechaDeCierre, titular);
		// TODO Auto-generated constructor stub
	}

}
