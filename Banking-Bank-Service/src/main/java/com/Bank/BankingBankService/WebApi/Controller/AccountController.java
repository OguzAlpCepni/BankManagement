package com.Bank.BankingBankService.WebApi.Controller;

import com.Bank.BankingBankService.Business.Dto.BankAccount;
import com.Bank.BankingBankService.Business.Dto.UtilityAccount;
import com.Bank.BankingBankService.Business.abstracts.BankAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
public class AccountController {
    private final BankAccountService bankAccountService;

    @GetMapping("/bank-account/{account_number}")
    public BankAccount getBankAccount(@PathVariable("account_number")String accountNumber){
        return bankAccountService.readBankAccount(accountNumber);
    }
    @GetMapping("/util-account/{account_name}")
    public UtilityAccount getUtilityAccount(@PathVariable("account_name") String providerName) {
        return bankAccountService.readUtilityAccount(providerName);
    }
}
