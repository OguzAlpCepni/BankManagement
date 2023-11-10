package com.Bank.BankingBankService.Business.abstracts;

import com.Bank.BankingBankService.Business.Dto.BankAccount;
import com.Bank.BankingBankService.Business.Dto.UtilityAccount;

public interface BankAccountService {
    public BankAccount readBankAccount(String accountNumber);
    public UtilityAccount readUtilityAccount(String provider);
    public UtilityAccount readUtilityAccount(Long id);
}