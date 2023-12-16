package com.Bank.BankingFundTransferService.Business.DTO;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class BankAccount {
    private Long id;
    private String number;
    private String type;
    private String status;
    private BigDecimal availableBalance;
    private BigDecimal actualBalance;

}
