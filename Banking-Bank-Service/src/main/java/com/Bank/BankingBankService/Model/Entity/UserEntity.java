package com.Bank.BankingBankService.Model.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name ="first_name")
    private String firstName;
    @Column(name ="last_name")
    private String lastName;

    @Column(name ="email")
    private String email;
    @Column(name ="identifaciton_number")
    private String identificationNumber;
    @OneToMany(mappedBy = "user")
    private List<BankAccountEntity> accounts;
}
