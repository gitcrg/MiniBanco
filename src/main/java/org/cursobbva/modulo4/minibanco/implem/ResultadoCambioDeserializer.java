package org.cursobbva.modulo4.minibanco.implem;

import java.io.IOException;

import org.cursobbva.modulo4.minibanco.interf.ResultadoCambio;

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
			public Float getTasa() {
				return (float) nodo.get("info").get("rate").asDouble(); 
			}

			@Override
			public Float getResultado() {
				return (float) nodo.get("result").asDouble();
			}
		};
	}

}
