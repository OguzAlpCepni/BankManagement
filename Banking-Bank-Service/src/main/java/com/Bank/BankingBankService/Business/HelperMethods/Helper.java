package com.Bank.BankingBankService.Business.HelperMethods;

import com.Bank.BankingBankService.Business.Dto.BankAccount;

import java.math.BigDecimal;

public interface Helper {
    void validateBalance(BankAccount bankAccount, BigDecimal amount);
    String internalFundTransfer(BankAccount fromBankAccount, BankAccount toBankAccount, BigDecimal amount);
}
