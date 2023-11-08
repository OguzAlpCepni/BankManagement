package com.Bank.BankingBankService.DataAccess;

import com.Bank.BankingBankService.Model.Entity.UtilityAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilityAccountRepository extends JpaRepository<UtilityAccountEntity,Long> {
}
