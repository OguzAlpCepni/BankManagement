package com.Bank.BankingUtilityPaymentService.model.entity;

import com.Bank.BankingUtilityPaymentService.model.enums.TransactionStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
@Entity
@Data
@Table(name="utility_payment")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UtilityPaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name="provider_id")
    private Long providerId;
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
