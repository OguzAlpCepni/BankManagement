package com.Bank.BankingBankService.DataAccess;

import com.Bank.BankingBankService.Model.Entity.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity,Long> {
}
