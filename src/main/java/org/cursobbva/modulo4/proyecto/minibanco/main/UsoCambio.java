package org.cursobbva.modulo4.proyecto.minibanco.main;

import java.util.HashMap;
import java.util.Map;

import org.cursobbva.modulo4.proyecto.minibanco.interf.ResultadoCambio;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
/**
 * Main para consumir API de cambio de moneda extranjera
 * @author Cristian Gutierrez
 *
 */

public class UsoCambio {

	public static void main(String[] args) {

		HttpEntity<Void> httpEntity;
		RestTemplate template;
		
		String baseUri = "https://api.apilayer.com/exchangerates_data/";
		String queryCambiar = "convert?to={to}&from={from}&amount={amount}";

		Map<String, String> variables = new HashMap<>();
		variables.put("from", "USD");
		variables.put("to", "ARS");
		variables.put("amount", "123");
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("apikey", "3Byam4MM8LP1xvY3hMUK0JB0e0wcisC8");//3Byam4MM8LP1xvY3hMUK0JB0e0wcisC8
		httpEntity = new HttpEntity<>(headers);

	
		template = new RestTemplate();
		ResponseEntity<ResultadoCambio> respuesta = template.exchange(baseUri + queryCambiar, HttpMethod.GET, httpEntity, ResultadoCambio.class, variables);

	    ResultadoCambio rs = respuesta.getBody();
	    
	    System.out.println("TASA OBTENIDA" + rs.getTasa());		
	    System.out.println("RESULTADO" + rs.getResultado());
	    
	}

}
