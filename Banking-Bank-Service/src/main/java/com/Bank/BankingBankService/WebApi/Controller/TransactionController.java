package com.Bank.BankingBankService.WebApi.Controller;

import com.Bank.BankingBankService.Business.Dto.Request.FundtTransferRequest;
import com.Bank.BankingBankService.Business.Dto.Request.UtilityPaymentRequest;
import com.Bank.BankingBankService.Business.abstracts.TransactionService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping(value = "/api/transaction")
public class TransactionController {
    private final TransactionService transactionService;
    @PostMapping("/fund-transfer")
    public ResponseEntity fundTransfer(@RequestBody FundtTransferRequest fundTransferRequest) {

        log.info("Fund transfer initiated in core bank from {}", fundTransferRequest.toString());
        return ResponseEntity.ok(transactionService.fundTransfer(fundTransferRequest));

    }
    @PostMapping("/util-payment")
    public ResponseEntity utilPayment(@RequestBody UtilityPaymentRequest utilityPaymentRequest) {

        log.info("Utility Payment initiated in core bank from {}", utilityPaymentRequest.toString());
        return ResponseEntity.ok(transactionService.utilPayment(utilityPaymentRequest));

    }
}
