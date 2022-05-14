package org.cursobbva.modulo4.proyecto.minibanco.modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Venta extends CompraVenta{

	public Venta(LocalDateTime fechayHoraDeRealizacion, float monto, String descripción, float cotizacion,
			float comision) {
		super(fechayHoraDeRealizacion, monto, descripción, cotizacion, comision);
		// TODO Auto-generated constructor stub
	}

	

}
