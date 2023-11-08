package com.Bank.BankingBankService.DataAccess;

import com.Bank.BankingBankService.Model.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> findByIdentificationNumber(String identificationNumber);
}
