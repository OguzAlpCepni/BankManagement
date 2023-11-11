package com.Bank.BankingBankService.Business.concreate;

import com.Bank.BankingBankService.Business.Dto.BankAccount;
import com.Bank.BankingBankService.Business.Dto.Request.FundtTransferRequest;
import com.Bank.BankingBankService.Business.Dto.Request.UtilityPaymentRequest;
import com.Bank.BankingBankService.Business.Dto.Response.FundTransferResponse;
import com.Bank.BankingBankService.Business.Dto.Response.UtilityPaymentResponse;
import com.Bank.BankingBankService.Business.HelperMethods.Helper;
import com.Bank.BankingBankService.Business.abstracts.BankAccountService;
import com.Bank.BankingBankService.Business.abstracts.TransactionService;
import com.Bank.BankingBankService.Business.abstracts.UtilityAccountService;
import com.Bank.BankingBankService.DataAccess.BankAccountsRepository;
import com.Bank.BankingBankService.DataAccess.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@AllArgsConstructor
@Transactional
public class TransactionManager implements TransactionService {
    private final TransactionRepository transactionRepository;
    private final BankAccountsRepository bankAccountsRepository;
    private final BankAccountService bankAccountService;
    private final UtilityAccountService utilityAccountService;
    private final Helper helper;

    @Override//// Method to manage fund transfer operations
    public FundTransferResponse fundTransfer(FundtTransferRequest fundtTransferRequest) {
        // Get sender and receiver bank accounts
        BankAccount  fromBankAccount = bankAccountService.readBankAccount(fundtTransferRequest.getFromAccount());
        BankAccount toBankAccount = bankAccountService.readBankAccount(fundtTransferRequest.getToAccount());

        // Check account balances
        helper.validateBalance(fromBankAccount,fundtTransferRequest.getAmount());

        // Perform internal fund transfer
        String transactionId = helper.internalFundTransfer(fromBankAccount,toBankAccount,fundtTransferRequest.getAmount());

        // Return a response with transaction details
        return FundTransferResponse.builder().message("Transaction successfully completed").transactionId(transactionId).build();
    }

    @Override//// Method to manage service payments
    public UtilityPaymentResponse utilPayment(UtilityPaymentRequest utilityPaymentRequest) {
        String transactionId = UUID.randomUUID().toString();


        return null;
    }
}
