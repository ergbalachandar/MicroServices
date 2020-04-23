package com.microservice.forexservice.exchangevalueresponsedto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ExchangeValueResponseDto {

	private Long id;
    private String from;
    private String to;
    private BigDecimal conversionMultiple;
	private int port;

}
