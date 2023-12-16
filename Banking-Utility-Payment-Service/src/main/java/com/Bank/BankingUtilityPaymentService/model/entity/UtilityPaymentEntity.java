package com.Bank.BankingUtilityPaymentService.model.entity;

import com.Bank.BankingUtilityPaymentService.model.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Table(name="utility_payment")
@AllArgsConstructor
@NoArgsConstructor
public class UtilityPaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="provide_id")
    private long provideId;
    @Column(name="amount")
    private BigDecimal amount;
    @Column(name="reference_number")
    private String  referenceNumber;
    @Column(name="account")
    private String account;
    @Column(name="transaction_id")
    private String transactionId;
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
}
