package com.Bank.BankingFundTransferService.webApi.controllers;

import com.Bank.BankingFundTransferService.Business.abstracts.FundTransferService;
import com.Bank.BankingFundTransferService.Business.response.GetAllFundTransferResponses;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController // annotation bilgilendirme ifadesidir
@RequestMapping("/api/fundTransfer")
@AllArgsConstructor
public class FundTransferController {
    private FundTransferService fundTransferService;

    @GetMapping()
    public List<GetAllFundTransferResponses> getAllTransfers(){
        return fundTransferService.getAllTransfers();
    }
}
