package com.Bank.BankingUserService.dataAccess;

import com.Bank.BankingUserService.model.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    List<UserEntity> findByEmail(String email);
}
