package com.microservice.forexservice.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.forexservice.entity.ExchangeValue;

public interface ExchangeValueRepoInterface extends JpaRepository<ExchangeValue, Long> {

	ExchangeValue findByFromAndTo(String from, String to);

}