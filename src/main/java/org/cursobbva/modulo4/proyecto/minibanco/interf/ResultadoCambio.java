package org.cursobbva.modulo4.proyecto.minibanco.interf;

import org.cursobbva.modulo4.proyecto.minibanco.implem.ResultadoCambioDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ResultadoCambioDeserializer.class)
public interface ResultadoCambio {
	/**
	 * @return Tasa aplicada al cambio
	 */
	public Double getTasa();

	/**
	 * @return El resultado de la conversion
	 */
	public Double getResultado();

}
