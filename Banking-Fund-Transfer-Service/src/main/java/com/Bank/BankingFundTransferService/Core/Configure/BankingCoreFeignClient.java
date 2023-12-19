package com.Bank.BankingFundTransferService.Core.Configure;

import com.Bank.BankingFundTransferService.Business.DTO.BankAccount;
import com.Bank.BankingFundTransferService.Business.DTO.FundTransfer;
import com.Bank.BankingFundTransferService.Business.DTO.request.FundTransferRequest;
import com.Bank.BankingFundTransferService.Business.DTO.response.FundTransferResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(name ="Banking-Api-Gateway",configuration = CustomFeignClientConfiguration.class)
public interface BankingCoreFeignClient {
    @GetMapping(value="bank/api/account/bank-account/{account_number}")
    BankAccount getBankAccount(@PathVariable("account_number") String accountNumber);

    @GetMapping(value="bank/api/transaction/fund-transfer")
    FundTransferResponse fundTransfer(@RequestBody FundTransferRequest fundTransferRequest);
    //  önemli bu method bize bir mesaj ve transactionId döndürecek

}