package com.Bank.BankingFundTransferService;

import com.Bank.BankingFundTransferService.Core.exceptions.BusinessException;
import com.Bank.BankingFundTransferService.Core.exceptions.ProblemDetails;
import com.Bank.BankingFundTransferService.Core.exceptions.ValidationProblemDetails;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@SpringBootApplication
@RestControllerAdvice
@EnableDiscoveryClient
public class BankingFundTransferServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankingFundTransferServiceApplication.class, args);
	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		return problemDetails;


	}
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation exception");
		validationProblemDetails.setValidationErrors(new HashMap<String,String>());
		//validationProblemDetails.getValidationErrors().put ....... diye gider fakat pratik olarak
		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors())
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());


		return validationProblemDetails;


	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
