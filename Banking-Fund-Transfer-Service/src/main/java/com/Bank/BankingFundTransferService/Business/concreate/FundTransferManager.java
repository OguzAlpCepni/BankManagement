package com.Bank.BankingFundTransferService.Business.concreate;

import com.Bank.BankingFundTransferService.Business.abstracts.FundTransferService;
import com.Bank.BankingFundTransferService.Business.DTO.request.FundTransferRequest;
import com.Bank.BankingFundTransferService.Business.DTO.response.FundTransferResponse;
import com.Bank.BankingFundTransferService.Business.DTO.response.GetAllFundTransferResponses;
import com.Bank.BankingFundTransferService.Core.Configure.BankingCoreFeignClient;
import com.Bank.BankingFundTransferService.Core.mappers.ModelMapperService;
import com.Bank.BankingFundTransferService.DataAccess.FundTransferRepository;
import com.Bank.BankingFundTransferService.Model.Entity.FundTransferEntity;
import com.Bank.BankingFundTransferService.Model.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class FundTransferManager implements FundTransferService {

    private FundTransferRepository fundTransferRepository;
    private ModelMapperService modelMapperService;
    private BankingCoreFeignClient bankingCoreFeignClient;
    @Override
    public List<GetAllFundTransferResponses> getAllTransfers() {
        List<FundTransferEntity> fundTransferEntities = fundTransferRepository.findAll();
        return fundTransferEntities.stream()
                .map(fundtransferEntity->this.modelMapperService.forResponse().map(fundtransferEntity, GetAllFundTransferResponses.class)).collect(Collectors.toList());

    }

    @Override
    public FundTransferResponse fundTransfer(FundTransferRequest fundTransferRequest) {
        FundTransferEntity fundTransferEntity = this.modelMapperService.forRequest().map(fundTransferRequest,FundTransferEntity.class);
        fundTransferEntity.setStatus(TransactionStatus.PENDING);
        FundTransferEntity optFundTransfer = fundTransferRepository.save(fundTransferEntity);

        FundTransferResponse fundTransferResponse = bankingCoreFeignClient.fundTransfer(fundTransferRequest);
        optFundTransfer.setTransactionReference(fundTransferResponse.getTransactionId());
        optFundTransfer.setStatus(TransactionStatus.SUCCESS);
        fundTransferRepository.save(optFundTransfer);

        fundTransferResponse.setMessage("Fund Transfer Successfully Completed");
        return fundTransferResponse;
    }
}
