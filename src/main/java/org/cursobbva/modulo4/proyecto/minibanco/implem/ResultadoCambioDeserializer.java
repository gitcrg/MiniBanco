package org.cursobbva.modulo4.proyecto.minibanco.implem;

import java.io.IOException;

import org.cursobbva.modulo4.proyecto.minibanco.interf.ResultadoCambio;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class ResultadoCambioDeserializer extends JsonDeserializer<ResultadoCambio> {

	@Override
	public ResultadoCambio deserialize(JsonParser jp, DeserializationContext desContext) throws IOException, JacksonException {
		JsonNode nodo = jp.getCodec().readTree(jp);
		return new ResultadoCambio() {
			@Override
			public Double getTasa() {
				return nodo.get("info").get("rate").asDouble(); 
			}

			@Override
			public Double getResultado() {
				return nodo.get("result").asDouble();
			}
		};
	}

}
