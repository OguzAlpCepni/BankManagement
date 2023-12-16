package com.Bank.BankingUserService.business.abstracts;

import com.Bank.BankingUserService.business.dto.User;
import com.Bank.BankingUserService.business.dto.requests.CreateUserRequest;
import com.Bank.BankingUserService.business.dto.requests.UpdateUserRequest;
import com.Bank.BankingUserService.business.dto.responses.GetAllUserResponse;
import com.Bank.BankingUserService.business.dto.responses.GetByIdUserResponse;

import java.util.List;

public interface UserService {
    List<GetAllUserResponse> getAll();
    GetByIdUserResponse getById(long id);
    CreateUserRequest add(CreateUserRequest createUserRequest);

    void delete(long id);
}
