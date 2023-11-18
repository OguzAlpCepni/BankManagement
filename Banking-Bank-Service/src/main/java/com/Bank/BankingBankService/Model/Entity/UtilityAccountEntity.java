package com.Bank.BankingBankService.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "utility_account")
@AllArgsConstructor
@NoArgsConstructor
public class UtilityAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "number")
    private String number;

    @Column(name = "provider_name")
    private String providerName;

}
