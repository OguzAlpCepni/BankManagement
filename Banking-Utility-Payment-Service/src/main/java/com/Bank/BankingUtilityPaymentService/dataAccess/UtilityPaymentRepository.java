package com.Bank.BankingUtilityPaymentService.dataAccess;

import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPayment;
import com.Bank.BankingUtilityPaymentService.model.entity.UtilityPaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


public interface UtilityPaymentRepository extends JpaRepository<UtilityPaymentEntity, Long> {
}
