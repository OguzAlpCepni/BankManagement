package com.Bank.BankingFundTransferService.Business.response;

import lombok.Data;

@Data
public class FundTransferResponse {
    private String message;
    private String transactionId;
}