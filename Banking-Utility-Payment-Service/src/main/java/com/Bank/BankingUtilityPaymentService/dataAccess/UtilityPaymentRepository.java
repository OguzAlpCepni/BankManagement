package com.Bank.BankingUtilityPaymentService.dataAccess;

import com.Bank.BankingUtilityPaymentService.model.entity.UtilityPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilityPaymentRepository extends JpaRepository<UtilityPaymentEntity,Long> {
}
