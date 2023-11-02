package com.Bank.BankingFundTransferService.Model.Dto.Request;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class UtilityPaymentRequest {
    private Long providerId;
    private BigDecimal amount;
    private String referenceNumber;
    private String account;
}
