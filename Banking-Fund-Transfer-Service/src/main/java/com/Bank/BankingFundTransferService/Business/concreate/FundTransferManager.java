package com.Bank.BankingFundTransferService.Business.concreate;

import com.Bank.BankingFundTransferService.Business.abstracts.FundTransferService;
import com.Bank.BankingFundTransferService.Business.request.FundTransferRequest;
import com.Bank.BankingFundTransferService.Business.response.FundTransferResponse;
import com.Bank.BankingFundTransferService.Business.response.GetAllFundTransferResponses;
import com.Bank.BankingFundTransferService.Core.mappers.ModelMapperService;
import com.Bank.BankingFundTransferService.DataAccess.FundTransferRepository;
import com.Bank.BankingFundTransferService.Model.Entity.FundTransferEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FundTransferManager implements FundTransferService {

    private FundTransferRepository fundTransferRepository;
    private ModelMapperService modelMapperService;
    @Override
    public List<GetAllFundTransferResponses> getAllTransfers() {
        List<FundTransferEntity> fundTransferEntities = fundTransferRepository.findAll();
        return fundTransferEntities.stream()
                .map(fundtransferEntity->this.modelMapperService.forResponse().map(fundtransferEntity, GetAllFundTransferResponses.class)).collect(Collectors.toList());

    }

    @Override
    public FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest) {
        return null;
    }
}
