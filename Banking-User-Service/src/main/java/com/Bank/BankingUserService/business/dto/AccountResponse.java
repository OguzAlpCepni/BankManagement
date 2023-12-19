package com.Bank.BankingUserService.business.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class AccountResponse {
    private String number;
    private BigDecimal actualBalance;
    private long id;
    private String type;
    private String status;
    private BigDecimal availableBalance;
}
