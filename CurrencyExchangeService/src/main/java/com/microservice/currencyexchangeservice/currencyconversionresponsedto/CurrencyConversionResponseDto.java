package com.microservice.currencyexchangeservice.currencyconversionresponsedto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CurrencyConversionResponseDto {

	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	private int port;

}
