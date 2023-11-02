package com.Bank.BankingFundTransferService.Model.Dto.Request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundTransferRequest {
    private String fromAccount;
    private String toAccount;
    private String authID;
    private BigDecimal amount;
}
