package com.Bank.BankingBankService.Business.Dto.Request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UtilityPaymentRequest {
    private Long providerId;
    private BigDecimal amount;
    private String referanceNumber;

    private String account;
}
