package com.Bank.BankingFundTransferService.Business.abstracts;

import com.Bank.BankingFundTransferService.Business.request.FundTransferRequest;
import com.Bank.BankingFundTransferService.Business.response.FundTransferResponse;
import com.Bank.BankingFundTransferService.Business.response.GetAllFundTransferResponses;

import java.util.List;

public interface FundTransferService {
    List<GetAllFundTransferResponses> getAllTransfers();
    FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest);
}
