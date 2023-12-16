package com.Bank.BankingUtilityPaymentService.business.DTO;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
@Data
@Builder
public class UtilityPaymentResponse {
    private String message;
    private String transactionId;
}
