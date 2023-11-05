package com.Bank.BankingFundTransferService.Model.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import java.math.BigDecimal;
@Data
@Entity
@Table(name="fund_transfer")
public class FundTransferEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionReference;
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

}
