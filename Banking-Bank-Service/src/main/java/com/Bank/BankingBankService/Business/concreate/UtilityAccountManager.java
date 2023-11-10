package com.Bank.BankingBankService.Business.concreate;

import com.Bank.BankingBankService.Business.Dto.UtilityAccount;
import com.Bank.BankingBankService.Business.abstracts.UtilityAccountService;
import com.Bank.BankingBankService.Core.exceptions.EntityNotFoundException;
import com.Bank.BankingBankService.Core.mapper.ModelMapperService;
import com.Bank.BankingBankService.DataAccess.UtilityAccountRepository;
import com.Bank.BankingBankService.Model.Entity.UtilityAccountEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UtilityAccountManager implements UtilityAccountService {
    private final UtilityAccountRepository utilityAccountRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public UtilityAccount readUtilityAccount(String provider) {
        UtilityAccountEntity utilityAccountEntity = utilityAccountRepository.findByProviderName(provider).orElseThrow(EntityNotFoundException::new);
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
