package com.Bank.BankingBankService.DataAccess;

import com.Bank.BankingBankService.Model.Entity.UtilityAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UtilityAccountRepository extends JpaRepository<UtilityAccountEntity,Long> {
    Optional<UtilityAccountEntity> findByProviderName(String provider);
}
