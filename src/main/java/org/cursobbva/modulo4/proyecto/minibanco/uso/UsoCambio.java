package org.cursobbva.modulo4.proyecto.minibanco.uso;

import java.util.HashMap;
import java.util.Map;

import org.cursobbva.modulo4.minibanco.implem.ResultadoCambioImplem;
import org.cursobbva.modulo4.minibanco.interf.ResultadoCambio;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


public class UsoCambio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//	    Request request = new Request.Builder()
//	      .url("https://api.apilayer.com/exchangerates_data/convert?to={to}&from={from}&amount={amount}")
//	      .addHeader("apikey", "3Byam4MM8LP1xvY3hMUK0JB0e0wcisC8")
//	      .method("GET", })
//	      .build();
//	    Response response = client.newCall(request).execute();
//	    System.out.println(response.body().string());
	    
		System.out.println("AARANCO POR ACCA!!!!");
		HttpEntity<Void> httpEntity;
		RestTemplate template;
		
		//https://api.apilayer.com/exchangerates_data/convert?to=ARS&from=USD&amount=10&
		//curl --request GET 'https://api.apilayer.com/exchangerates_data/live?base=USD&symbols=EUR,GBP' \ --header 'apikey: 3Byam4MM8LP1xvY3hMUK0JB0e0wcisC8'
		//curl --request GET 'https://api.apilayer.com/currency_data/convert?base=USD&symbols=EUR,GBP,JPY&amount=5&date=2018-01-01' \--header 'apikey: 3Byam4MM8LP1xvY3hMUK0JB0e0wcisC8'
		//curl https://api.apilayer.com/exchangerates_data/convert?to={to}&from={from}&amount={amount}").addHeader("apikey", "3Byam4MM8LP1xvY3hMUK0JB0e0wcisC8"
		//curl --request GET 'https://api.apilayer.com/fixer/date=2018-01-01' \ --header 'apikey: 3Byam4MM8LP1xvY3hMUK0JB0e0wcisC8'
		
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
	    System.out.println(respuesta.getBody()+"BODY!!!");

	    ResultadoCambio rs = respuesta.getBody();
	    
	    System.out.println(rs.getTasa());
	    System.out.println(rs.getResultado());
		System.out.println("SIGO POR ACCA!!!!");
		
	}

}
