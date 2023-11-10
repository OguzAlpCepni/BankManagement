package com.Bank.BankingBankService.Business.concreate;

import com.Bank.BankingBankService.Business.Dto.BankAccount;
import com.Bank.BankingBankService.Business.Dto.User;
import com.Bank.BankingBankService.Business.abstracts.BankAccountService;
import com.Bank.BankingBankService.Core.exceptions.EntityNotFoundException;
import com.Bank.BankingBankService.Core.mapper.ModelMapperService;
import com.Bank.BankingBankService.DataAccess.BankAccountsRepository;
import com.Bank.BankingBankService.Model.Entity.BankAccountEntity;
import com.Bank.BankingBankService.Model.Entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountManager implements BankAccountService {
    private  final BankAccountsRepository bankAccountsRepository;
    private final ModelMapperService modelMapperService;


    @Override
    public BankAccount readBankAccount(String accountNumber) {
        BankAccountEntity bankAccountEntity = bankAccountsRepository.findByNumber(accountNumber).orElseThrow(EntityNotFoundException::new);
        BankAccount bankAccount = this.modelMapperService.forResponse().map(bankAccountEntity, BankAccount.class);
        return bankAccount;
    }
}
