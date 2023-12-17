package com.Bank.BankingBankService.Business.concreate;

import com.Bank.BankingBankService.Business.Dto.BankAccount;
import com.Bank.BankingBankService.Business.Dto.UtilityAccount;
import com.Bank.BankingBankService.Business.abstracts.BankAccountService;
import com.Bank.BankingBankService.Core.exceptions.EntityNotFoundException;
import com.Bank.BankingBankService.Core.mapper.ModelMapperService;
import com.Bank.BankingBankService.DataAccess.BankAccountsRepository;
import com.Bank.BankingBankService.DataAccess.UtilityAccountRepository;
import com.Bank.BankingBankService.Model.Entity.BankAccountEntity;
import com.Bank.BankingBankService.Model.Entity.UtilityAccountEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountManager implements BankAccountService {
    private  BankAccountsRepository bankAccountsRepository;
    private  ModelMapperService modelMapperService;
    private  UtilityAccountRepository utilityAccountRepository;
    
    @Override
    public BankAccount readBankAccount(String accountNumber) {
        BankAccountEntity bankAccountEntity = bankAccountsRepository.findByNumber(accountNumber);
        BankAccount bankAccount = this.modelMapperService.forResponse().map(bankAccountEntity, BankAccount.class);
        return bankAccount;
    }

    @Override
    public UtilityAccount readUtilityAccount(String provider) {
        UtilityAccountEntity utilityAccountEntity = utilityAccountRepository.findByProviderName(provider);
        UtilityAccount utilityAccount = this.modelMapperService.forResponse().map(utilityAccountEntity,UtilityAccount.class);
        return utilityAccount;
    }

    @Override
    public UtilityAccount readUtilityAccount(Long id) {
        UtilityAccountEntity utilityAccountEntity = utilityAccountRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        UtilityAccount utilityAccount = this.modelMapperService.forResponse().map(utilityAccountEntity,UtilityAccount.class);
        return utilityAccount;
    }
}
