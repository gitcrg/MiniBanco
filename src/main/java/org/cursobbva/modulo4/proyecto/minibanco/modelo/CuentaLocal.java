package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;

public class CuentaLocal extends Cuenta{

	public CuentaLocal(Long numero, LocalDate fechaDeDreaci�n, float saldoInicial, float saldoActual,
			float descubiertoAcordado, LocalDate fechaDeCierre, ClienteTitular titular) {
		super(numero, fechaDeDreaci�n, saldoInicial, saldoActual, descubiertoAcordado, fechaDeCierre, titular);
		// TODO Auto-generated constructor stub
	}

}
