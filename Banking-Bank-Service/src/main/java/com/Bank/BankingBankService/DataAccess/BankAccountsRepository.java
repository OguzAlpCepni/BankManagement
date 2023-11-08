package com.Bank.BankingBankService.DataAccess;

import com.Bank.BankingBankService.Business.Dto.BankAccount;
import com.Bank.BankingBankService.Model.Entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountsRepository extends JpaRepository<BankAccountEntity,Long> {
    Optional<BankAccountEntity> findByNumber(String accountNumber);
}
