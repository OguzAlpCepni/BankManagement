package com.Bank.BankingUtilityPaymentService.webApi.Controller;

import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPayment;
import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPaymentRequest;
import com.Bank.BankingUtilityPaymentService.business.DTO.UtilityPaymentResponse;
import com.Bank.BankingUtilityPaymentService.business.abstracts.UtilityPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/utilityPayment")
@AllArgsConstructor
public class UtilityPaymentController {
    private UtilityPaymentService utilityPaymentService;
    @GetMapping()
    public List<UtilityPayment> readPayments(){
       return utilityPaymentService.readPayments();
    }
    @PostMapping()
    public UtilityPaymentResponse utilPayment(UtilityPaymentRequest paymentRequest){
        return utilityPaymentService.utilPayment(paymentRequest);
    }
}
