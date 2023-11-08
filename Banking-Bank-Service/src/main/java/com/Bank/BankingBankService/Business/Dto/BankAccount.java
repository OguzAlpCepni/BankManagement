package com.Bank.BankingBankService.Business.Dto;

import com.Bank.BankingBankService.Model.Enum.AccountStatus;
import com.Bank.BankingBankService.Model.Enum.AccountType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccount {
    private Long id;
    private String number;
    private AccountType type;
    private AccountStatus status;
    private BigDecimal availableBalance;
    private BigDecimal actualBalance;
    private User user;
}
