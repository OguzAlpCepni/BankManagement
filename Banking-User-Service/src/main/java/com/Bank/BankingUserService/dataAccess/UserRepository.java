package com.Bank.BankingUserService.dataAccess;

import com.Bank.BankingUserService.model.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
}
