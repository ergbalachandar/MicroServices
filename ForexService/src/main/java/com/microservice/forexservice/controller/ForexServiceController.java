package com.microservice.forexservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservice.forexservice.exchangevalueresponsedto.ExchangeValueResponseDto;
import com.microservice.forexservice.service.ExchangeValueService;
import com.microservice.forexservice.util.ExchangeValueUtil;

public class ForexServiceController {

	@Autowired
	ExchangeValueService exchangeValueService;

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValueResponseDto retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		
		ExchangeValueResponseDto exchangeValueResponseDto = new ExchangeValueResponseDto();
        ExchangeValueUtil.mapExchangeValueResponse(exchangeValueService.retrieveExchangeValue(from, to),
				exchangeValueResponseDto);

		return exchangeValueResponseDto;
	}
}
