package org.cursobbva.modulo4.minibanco.implem;



import java.util.HashMap;
import java.util.Map;

import org.cursobbva.modulo4.minibanco.interf.ResultadoCambio;
import org.cursobbva.modulo4.minibanco.interf.ServicioCambio;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("servicioCambio")
public class ServicioCambioImplem implements ServicioCambio{

	HttpEntity<Void> httpEntity;
	RestTemplate template = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	Map<String, String> variables = new HashMap<>();

	String baseUri = "https://api.apilayer.com/exchangerates_data/";
	String queryCambiar = "convert?to={to}&from={from}&amount={amount}";
    		
	@Override
	public ResultadoCambio cambiar(TipoMoneda de, TipoMoneda a, Float monto) {
		// TODO Auto-generated method stub
		
		variables.put("from", de.toString());
		variables.put("to", "ARS");
		variables.put("amount", monto.toString());

		headers.set("apikey", "3Byam4MM8LP1xvY3hMUK0JB0e0wcisC8");//3Byam4MM8LP1xvY3hMUK0JB0e0wcisC8 - ${rest.apikey}
		httpEntity = new HttpEntity<>(headers);

		ResponseEntity<ResultadoCambio> respuesta = template.exchange(baseUri + queryCambiar, HttpMethod.GET, httpEntity, ResultadoCambio.class, variables);
	    ResultadoCambio rs = respuesta.getBody();
		ResultadoCambio rc = new ResultadoCambioImplem(de, a, monto);

		return rs;
	}
	
		

}
