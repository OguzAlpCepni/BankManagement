package com.Bank.BankingFundTransferService.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
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
