package com.Bank.BankingFundTransferService.Business.concreate;

import com.Bank.BankingFundTransferService.Business.abstracts.FundTransferService;
import com.Bank.BankingFundTransferService.Business.request.FundTransferRequest;
import com.Bank.BankingFundTransferService.Business.response.FundTransferResponse;
import com.Bank.BankingFundTransferService.Business.response.GetAllFundTransferResponses;
import com.Bank.BankingFundTransferService.Core.mappers.ModelMapperService;
import com.Bank.BankingFundTransferService.DataAccess.FundTransferRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class FundTransferManager implements FundTransferService {

    private FundTransferRepository fundTransferRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllFundTransferResponses> getAllTransfers() {
        return null;
    }

    @Override
    public FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest) {
        return null;
    }
}
