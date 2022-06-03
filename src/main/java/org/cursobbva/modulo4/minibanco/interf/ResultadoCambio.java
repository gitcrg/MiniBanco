package org.cursobbva.modulo4.minibanco.interf;

import org.cursobbva.modulo4.minibanco.implem.ResultadoCambioDeserializer;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ResultadoCambioDeserializer.class)
public interface ResultadoCambio {
	/**
	 * @return Tasa aplicada al cambio
	 */
	public Float getTasa();

	/**
	 * @return El resultado de la conversion
	 */
	public Float getResultado();

}
