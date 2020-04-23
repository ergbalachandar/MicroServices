package com.microservice.forexservice.util;

import com.microservice.forexservice.entity.ExchangeValue;
import com.microservice.forexservice.exchangevalueresponsedto.ExchangeValueResponseDto;

public class ExchangeValueUtil {
	
	public static void mapExchangeValueResponse(ExchangeValue exchangeValue, ExchangeValueResponseDto exchangeValueResponseDto) {
		
		exchangeValueResponseDto.setConversionMultiple(exchangeValue.getConversionMultiple());
		exchangeValueResponseDto.setFrom(exchangeValue.getFrom());
		exchangeValueResponseDto.setId(exchangeValue.getId());
		exchangeValueResponseDto.setPort(exchangeValue.getPort());
		exchangeValueResponseDto.setTo(exchangeValue.getTo());
	}

}
