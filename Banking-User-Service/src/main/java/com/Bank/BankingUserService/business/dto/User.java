package com.Bank.BankingUserService.business.dto;

import com.Bank.BankingUserService.model.Enum.Status;
import lombok.Data;

@Data
public class User {
    private long id;
    private String email;
    private String identification;
    private String password;
    private Status status;
}
