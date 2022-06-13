package org.cursobbva.modulo4.proyecto.minibanco.implem;

import java.util.HashMap;
import java.util.Map;

import org.cursobbva.modulo4.proyecto.minibanco.interf.ResultadoCambio;
import org.cursobbva.modulo4.proyecto.minibanco.interf.ServicioCambio;
import org.cursobbva.modulo4.proyecto.minibanco.modelo.TipoMoneda;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
/**
 * 
 * @author Cristian Gutierrez
 *
 */

@Component("servicioCambio")
public class ServicioCambioImplem implements ServicioCambio{

	HttpEntity<Void> httpEntity;
	RestTemplate template = new RestTemplate();
	HttpHeaders headers = new HttpHeaders();
	Map<String, String> vars = new HashMap<>();

	String baseUri = "https://api.apilayer.com/exchangerates_data/";
	String queryCambiar = "convert?to={to}&from={from}&amount={amount}";
    		
	@Override
	public ResultadoCambio cambiar(TipoMoneda de, TipoMoneda a, Double monto) {
	
		vars.put("from", de.toString());
		vars.put("to", "ARS");
		vars.put("amount", monto.toString());

		headers.set("apikey", "3Byam4MM8LP1xvY3hMUK0JB0e0wcisC8");//3Byam4MM8LP1xvY3hMUK0JB0e0wcisC8 - ${rest.apikey}
		httpEntity = new HttpEntity<>(headers);

		ResponseEntity<ResultadoCambio> respuesta = template.exchange(baseUri + queryCambiar, HttpMethod.GET, httpEntity, ResultadoCambio.class, vars);
	    ResultadoCambio rs = respuesta.getBody();

		return rs;
	}
	
		

}
