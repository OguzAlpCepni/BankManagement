package com.Bank.BankingUserService.core.mapper.Exceptions;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}
