package com.Bank.BankingBankService.Business.concreate;

import com.Bank.BankingBankService.DataAccess.BankAccountsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountManager {
    private BankAccountsRepository bankAccountsRepository;

}
