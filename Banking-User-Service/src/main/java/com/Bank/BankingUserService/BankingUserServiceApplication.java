package com.Bank.BankingUserService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BankingUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingUserServiceApplication.class, args);
	}

}
