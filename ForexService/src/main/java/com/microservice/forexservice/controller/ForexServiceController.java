package com.microservice.forexservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.forexservice.entity.ExchangeValue;

public class ForexServiceController {
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	  public ExchangeValue retrieveExchangeValue
	    (@PathVariable String from, @PathVariable String to){
	    
	   
	    
	    return null;
	  }
	}


