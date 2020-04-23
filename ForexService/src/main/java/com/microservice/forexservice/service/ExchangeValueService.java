package com.microservice.forexservice.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.microservice.forexservice.entity.ExchangeValue;
import com.microservice.forexservice.interfaces.ExchangeValueRepoInterface;

public class ExchangeValueService {
	
	@Autowired
	ExchangeValueRepoInterface exchangeValueRepoInterface;
	
	public ExchangeValue retrieveExchangeValue(String from, String to) {
		
		return exchangeValueRepoInterface.findByFromAndTo(from, to);
		
	}

}
