package com.Bank.BankingUtilityPaymentService.business.concreate;

import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPayment;
import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPaymentRequest;
import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPaymentResponse;
import com.Bank.BankingUtilityPaymentService.business.abstracts.UtilityPaymentService;
import com.Bank.BankingUtilityPaymentService.core.Configure.BankingCoreRestClient;
import com.Bank.BankingUtilityPaymentService.core.mapper.ModelMapperService;
import com.Bank.BankingUtilityPaymentService.dataAccess.UtilityPaymentRepository;
import com.Bank.BankingUtilityPaymentService.model.entity.UtilityPaymentEntity;
import com.Bank.BankingUtilityPaymentService.model.enums.TransactionStatus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UtilityPaymentManager implements UtilityPaymentService {
    private ModelMapperService modelMapperService;
    private UtilityPaymentRepository utilityPaymentRepository;
    private BankingCoreRestClient bankingCoreRestClient;
    @Override
    public UtilityPaymentResponse utilPayment(UtilityPaymentRequest utilityPaymentRequest) {
        UtilityPaymentEntity utilityPaymentEntity =  modelMapperService.forRequest().map(utilityPaymentRequest,UtilityPaymentEntity.class);
        utilityPaymentEntity.setStatus(TransactionStatus.PROCESSING);
        UtilityPaymentEntity optUtilPayment = utilityPaymentRepository.save(utilityPaymentEntity);

        UtilityPaymentResponse utilityPaymentResponse = bankingCoreRestClient.utilPayment(utilityPaymentRequest);

        optUtilPayment.setStatus(TransactionStatus.SUCCESS);
        optUtilPayment.setTransactionId(utilityPaymentResponse.getTransactionId());
        utilityPaymentRepository.save(optUtilPayment);
        utilityPaymentResponse.setMessage("Utility Payment Successfully Processed");
        return utilityPaymentResponse;
    }

    @Override
    public List<UtilityPayment> readPayments() {
        List<UtilityPaymentEntity> utilityPaymentEntities = utilityPaymentRepository.findAll();
        return utilityPaymentEntities.stream()
                .map(utilityPaymentEntity->this.modelMapperService.forResponse().map(utilityPaymentEntity, UtilityPayment.class)).collect(Collectors.toList());
    }
}
