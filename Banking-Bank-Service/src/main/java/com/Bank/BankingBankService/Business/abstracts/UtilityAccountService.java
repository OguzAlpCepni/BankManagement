package com.Bank.BankingBankService.Business.abstracts;

import com.Bank.BankingBankService.Business.Dto.UtilityAccount;

public interface UtilityAccountService {
    UtilityAccount readUtilityAccount(String provider);
    UtilityAccount readUtilityAccount(Long id);
}
