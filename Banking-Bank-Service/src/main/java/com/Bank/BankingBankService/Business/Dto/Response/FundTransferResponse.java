package com.Bank.BankingBankService.Business.Dto.Response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Builder
@Getter
@Setter
public class FundTransferResponse{
    private String message;
    private String transactionId;
}
