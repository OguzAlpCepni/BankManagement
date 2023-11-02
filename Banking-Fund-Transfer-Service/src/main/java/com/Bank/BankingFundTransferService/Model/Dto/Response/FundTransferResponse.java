package com.Bank.BankingFundTransferService.Model.Dto.Response;

import lombok.Data;

@Data
public class FundTransferResponse {
    private String message;
    private String transactionId;
}
