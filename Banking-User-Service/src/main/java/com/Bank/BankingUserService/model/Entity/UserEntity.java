package com.Bank.BankingUserService.model.Entity;

import com.Bank.BankingUserService.model.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "identification")
    private String identification;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;



}
