package com.Bank.BankingBankService.Business.Dto.Response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@Builder
public class UtilityPaymentResponse {
    private String message;
    private String transactionId;
}
