package com.Bank.BankingFundTransferService.DataAccess;

import com.Bank.BankingFundTransferService.Model.Entity.FundTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundTransferRepository extends JpaRepository<FundTransferEntity,Long> {
}
