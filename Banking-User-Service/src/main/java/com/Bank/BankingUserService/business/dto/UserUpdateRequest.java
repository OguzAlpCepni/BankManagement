package com.Bank.BankingUserService.business.dto;

import com.Bank.BankingUserService.model.Enum.Status;
import lombok.Data;

@Data
public class UserUpdateRequest {
    private Status status;
}
