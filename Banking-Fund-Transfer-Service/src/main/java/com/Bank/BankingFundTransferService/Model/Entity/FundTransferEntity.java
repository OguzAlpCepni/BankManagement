package com.Bank.BankingFundTransferService.Model.Entity;


import com.Bank.BankingFundTransferService.Model.Enum.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table(name="fund_transfer")
public class FundTransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="transaction_reference")
    private String transactionReference;
    @Column(name="from_account")
    private String fromAccount;
    @Column(name="to_Account")
    private String toAccount;
    @Column(name="amount")
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

}
