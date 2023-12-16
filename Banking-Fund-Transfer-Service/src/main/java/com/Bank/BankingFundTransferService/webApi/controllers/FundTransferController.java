package com.Bank.BankingFundTransferService.webApi.controllers;

import com.Bank.BankingFundTransferService.Business.DTO.request.FundTransferRequest;
import com.Bank.BankingFundTransferService.Business.DTO.response.FundTransferResponse;
import com.Bank.BankingFundTransferService.Business.abstracts.FundTransferService;
import com.Bank.BankingFundTransferService.Business.DTO.response.GetAllFundTransferResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fund")
@AllArgsConstructor
public class FundTransferController {
    private FundTransferService fundTransferService;

    @GetMapping()
    public List<GetAllFundTransferResponses> getAllTransfers(){
        return fundTransferService.getAllTransfers();
    }

    @PostMapping()
    public FundTransferResponse sendFundTransfer(@RequestBody FundTransferRequest fundTransferRequest) {
        return fundTransferService.fundTransfer(fundTransferRequest);
    }
}
