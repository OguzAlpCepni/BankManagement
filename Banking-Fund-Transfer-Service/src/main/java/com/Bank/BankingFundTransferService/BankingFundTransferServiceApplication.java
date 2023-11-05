package com.Bank.BankingFundTransferService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaServer
public class BankingFundTransferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingFundTransferServiceApplication.class, args);
	}


	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
