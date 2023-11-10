package com.Bank.BankingBankService.Business.concreate;

import com.Bank.BankingBankService.Business.Dto.User;
import com.Bank.BankingBankService.Business.abstracts.UserService;
import com.Bank.BankingBankService.Core.exceptions.EntityNotFoundException;
import com.Bank.BankingBankService.Core.mapper.ModelMapperService;
import com.Bank.BankingBankService.DataAccess.UserRepository;
import com.Bank.BankingBankService.Model.Entity.UserEntity;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private  UserRepository userRepository;
    private ModelMapperService modelMapperService;
    @Override
    public User readUser(String identification) {
        UserEntity userEntity= userRepository.findByIdentificationNumber(identification).orElseThrow(EntityNotFoundException::new);
        User user = this.modelMapperService.forResponse().map(userEntity,User.class);
        return user;
    }

    @Override
    public List<User> readUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<User> users = userEntities.stream().map(userEntity->this.modelMapperService.forResponse().map(userEntity,User.class)).collect(Collectors.toList());
        return users;
    }
}
