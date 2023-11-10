package com.Bank.BankingBankService.Core.exceptions;

public class InsufficientFundsException extends SimpleBankingGlobalException{
    public InsufficientFundsException(String message, String code) {
        super(message, code);
    }
}
