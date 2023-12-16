package com.Bank.BankingFundTransferService.Business.DTO.response;

import lombok.Data;

@Data
public class FundTransferResponse {
    private String message;
    private String transactionId;
}
