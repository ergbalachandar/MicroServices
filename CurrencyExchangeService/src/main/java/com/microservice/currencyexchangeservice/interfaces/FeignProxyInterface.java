package com.microservice.currencyexchangeservice.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.currencyexchangeservice.currencyconversionresponsedto.CurrencyConversionResponseDto;

@FeignClient(name="forex-service", url="localhost:8000")
public interface FeignProxyInterface {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	  public CurrencyConversionResponseDto retrieveExchangeValue
	    (@PathVariable("from") String from, @PathVariable("to") String to);
}
