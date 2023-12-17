package com.Bank.BankingUtilityPaymentService.business.abstracts;

import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPayment;
import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPaymentRequest;
import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPaymentResponse;

import java.util.List;

public interface UtilityPaymentService {
    public UtilityPaymentResponse utilPayment(UtilityPaymentRequest paymentRequest);
    public List<UtilityPayment> readPayments();
}
