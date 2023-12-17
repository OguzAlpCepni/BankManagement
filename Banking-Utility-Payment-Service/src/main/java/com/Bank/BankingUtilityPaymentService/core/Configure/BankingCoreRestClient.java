package com.Bank.BankingUtilityPaymentService.core.Configure;

import com.Bank.BankingUtilityPaymentService.business.DTO.AccountResponse;
import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPaymentRequest;
import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="Banking-Api-Gateway")
public interface BankingCoreRestClient {
    @GetMapping(value="bank/api/account/bank-account/{account_number}")
    AccountResponse getBankAccount(@PathVariable("account_number")String accountNumber);

    @GetMapping (value="bank/api/transaction/util-payment")
    UtilityPaymentResponse utilPayment(@RequestBody UtilityPaymentRequest utilityPaymentRequest);

}
