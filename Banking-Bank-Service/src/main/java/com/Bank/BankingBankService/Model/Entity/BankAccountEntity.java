package com.Bank.BankingBankService.Model.Entity;

import com.Bank.BankingBankService.Model.Enum.AccountStatus;
import com.Bank.BankingBankService.Model.Enum.AccountType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "bank_account")
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    @Column(name="number")
    private String number;
    @Enumerated(EnumType.STRING)
    @Column(name="account_type")
    private AccountType accountType;

    @Enumerated(EnumType.STRING)
    @Column(name="account_status")
    private AccountStatus accountStatus;
    @Column(name = "available_balance")
    private BigDecimal availableBalance;
    @Column(name = "actual_balance")
    private BigDecimal actualBalance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

}
