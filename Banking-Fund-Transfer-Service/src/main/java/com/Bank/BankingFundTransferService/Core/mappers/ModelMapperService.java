package com.Bank.BankingFundTransferService.Core.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
    ModelMapper forRequestLoose();
}
