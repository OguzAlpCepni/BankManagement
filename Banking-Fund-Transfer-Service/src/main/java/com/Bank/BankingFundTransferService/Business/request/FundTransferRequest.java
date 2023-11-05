package com.Bank.BankingFundTransferService.Business.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundTransferRequest {
    private String fromAccount;
    private String toAccount;
    private String authID;
    private BigDecimal amount;
}
