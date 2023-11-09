package com.Bank.BankingBankService.Business.abstracts;

import com.Bank.BankingBankService.Business.Dto.Request.FundtTransferRequest;
import com.Bank.BankingBankService.Business.Dto.Request.UtilityPaymentRequest;
import com.Bank.BankingBankService.Business.Dto.Response.FundTransferResponse;
import com.Bank.BankingBankService.Business.Dto.Response.UtilityPaymentResponse;

public interface TransactionService {
    public FundTransferResponse fundTransfer(FundtTransferRequest fundtTransferRequest);
    public UtilityPaymentResponse utilPayment(UtilityPaymentRequest utilityPaymentRequest);
    
}
