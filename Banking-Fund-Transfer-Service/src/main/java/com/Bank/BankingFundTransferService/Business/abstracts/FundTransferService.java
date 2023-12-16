package com.Bank.BankingFundTransferService.Business.abstracts;

import com.Bank.BankingFundTransferService.Business.DTO.request.FundTransferRequest;
import com.Bank.BankingFundTransferService.Business.DTO.response.FundTransferResponse;
import com.Bank.BankingFundTransferService.Business.DTO.response.GetAllFundTransferResponses;

import java.util.List;

public interface FundTransferService {
    List<GetAllFundTransferResponses> getAllTransfers();
    FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest);
}
