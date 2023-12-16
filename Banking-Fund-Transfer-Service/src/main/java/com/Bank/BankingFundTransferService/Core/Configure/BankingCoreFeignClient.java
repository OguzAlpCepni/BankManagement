package com.Bank.BankingFundTransferService.Core.Configure;

import com.Bank.BankingFundTransferService.Business.DTO.BankAccount;
import com.Bank.BankingFundTransferService.Business.DTO.FundTransfer;
import com.Bank.BankingFundTransferService.Business.DTO.request.FundTransferRequest;
import com.Bank.BankingFundTransferService.Business.DTO.response.FundTransferResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(name ="Banking-Bank-Service")
public interface BankingCoreFeignClient {
    @GetMapping(value="/api/account/bank-account/{account_number}")
    public BankAccount getBankAccount(@PathVariable("account_number") String accountNumber);

    @PostMapping(value="/api/transaction/fund-transfer")
    public FundTransferResponse fundTransfer(@RequestBody FundTransferRequest fundTransferRequest);
    //  önemli bu method bize bir mesaj ve transactionId döndürecek

}