package com.Bank.BankingFundTransferService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BankingFundTransferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingFundTransferServiceApplication.class, args);
	}

}
