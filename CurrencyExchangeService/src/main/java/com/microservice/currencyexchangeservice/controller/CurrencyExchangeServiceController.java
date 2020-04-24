package com.microservice.currencyexchangeservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.microservice.currencyexchangeservice.currencyconversionresponsedto.CurrencyConversionResponseDto;
import com.microservice.currencyexchangeservice.interfaces.FeignProxyInterface;

@RestController
public class CurrencyExchangeServiceController {
	
	@Autowired
	private FeignProxyInterface feignProxyInterface;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionResponseDto convertCurrency(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionResponseDto> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionResponseDto.class,
				uriVariables);

		CurrencyConversionResponseDto response = responseEntity.getBody();
		response.setQuantity(quantity);
		response.setTotalCalculatedAmount(quantity.multiply(response.getConversionMultiple()));

		return response;
	}
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	  public CurrencyConversionResponseDto convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
	      @PathVariable BigDecimal quantity) {

		CurrencyConversionResponseDto currencyConversionResponseDto = feignProxyInterface.retrieveExchangeValue(from, to);
		currencyConversionResponseDto.setQuantity(quantity);
		currencyConversionResponseDto.setTotalCalculatedAmount(quantity.multiply(currencyConversionResponseDto.getConversionMultiple()));

		return currencyConversionResponseDto;
	    
	  }
}
