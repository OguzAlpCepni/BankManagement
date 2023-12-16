package com.Bank.BankingUserService.business.Rules;

import com.Bank.BankingUserService.business.dto.User;
import com.Bank.BankingUserService.business.dto.UserResponse;
import com.Bank.BankingUserService.business.dto.requests.CreateUserRequest;
import com.Bank.BankingUserService.core.mapper.Exceptions.BusinessException;
import com.Bank.BankingUserService.dataAccess.UserRepository;
import com.Bank.BankingUserService.model.Entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserBusinessRules {
    private UserRepository userRepository;

    public void checkIfUserMailExists(String email){
        List<UserEntity> userEntities = userRepository.findByEmail(email);
        if(!userEntities.isEmpty()){
            throw new BusinessException("This email is already registered. Please check and retry.");
        }
    }
    public void emailValidation(User user, CreateUserRequest createUserRequest){
        if(!user.getEmail().equals(createUserRequest.getEmail())){
            throw new BusinessException("Incorrect email. Please check and retry.");
        }
    }
}
