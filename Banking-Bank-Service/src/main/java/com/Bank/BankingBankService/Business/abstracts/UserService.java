package com.Bank.BankingBankService.Business.abstracts;

import com.Bank.BankingBankService.Business.Dto.User;

import java.util.List;

public interface UserService {
    public User readUser(String identification);
    public List<User> readUsers();
}
