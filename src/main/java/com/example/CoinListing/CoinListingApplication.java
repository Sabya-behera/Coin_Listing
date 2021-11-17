package com.example.CoinListing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoinListingApplication {
	private static final Logger LOGGER= LoggerFactory.getLogger(CoinListingApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CoinListingApplication.class, args);
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}
}
