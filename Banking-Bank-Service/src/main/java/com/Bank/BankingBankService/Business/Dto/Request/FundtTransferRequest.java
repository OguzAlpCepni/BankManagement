package com.Bank.BankingBankService.Business.Dto.Request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundtTransferRequest {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
}
