package com.Bank.BankingBankService.Business.concreate;

import com.Bank.BankingBankService.Business.Dto.BankAccount;
import com.Bank.BankingBankService.Business.Dto.Request.FundtTransferRequest;
import com.Bank.BankingBankService.Business.Dto.Request.UtilityPaymentRequest;
import com.Bank.BankingBankService.Business.Dto.Response.FundTransferResponse;
import com.Bank.BankingBankService.Business.Dto.Response.UtilityPaymentResponse;
import com.Bank.BankingBankService.Business.Dto.UtilityAccount;
import com.Bank.BankingBankService.Business.HelperMethods.Helper;
import com.Bank.BankingBankService.Business.abstracts.BankAccountService;
import com.Bank.BankingBankService.Business.abstracts.TransactionService;
import com.Bank.BankingBankService.DataAccess.BankAccountsRepository;
import com.Bank.BankingBankService.DataAccess.TransactionRepository;
import com.Bank.BankingBankService.Model.Entity.BankAccountEntity;
import com.Bank.BankingBankService.Model.Entity.TransactionEntity;
import com.Bank.BankingBankService.Model.Enum.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@AllArgsConstructor
@Transactional
public class TransactionnManager implements TransactionService {
    private TransactionRepository transactionRepository;
    private BankAccountsRepository bankAccountsRepository;
    private BankAccountService bankAccountService;
    private Helper helper;

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
        // Create a unique process ID
        String transactionId = UUID.randomUUID().toString();
        // Get the bank account to be calculated(hesaplanıcak banka hesabını al)
        BankAccount fromBankAccount = bankAccountService.readBankAccount(utilityPaymentRequest.getAccount());
        // Hesap bakiyesini kontrol et
        helper.validateBalance(fromBankAccount,utilityPaymentRequest.getAmount());
        // Hizmet sağlayıcının bilgilerini al
        UtilityAccount utilityAccount = bankAccountService.readUtilityAccount(utilityPaymentRequest.getProviderId());
        // Gönderen banka hesap varlığını al
        BankAccountEntity fromAccount = bankAccountsRepository.findByNumber(fromBankAccount.getNumber());
        // Hizmet ödemesinden sonra gönderen hesap bakiyesini güncelle
        fromAccount.setActualBalance(fromAccount.getActualBalance().subtract(utilityPaymentRequest.getAmount()));
        fromAccount.setAvailableBalance(fromAccount.getActualBalance().subtract(utilityPaymentRequest.getAmount()));
        // Hizmet ödeme işlemini kaydet
        transactionRepository.save(TransactionEntity.builder().transactionType(TransactionType.UTILITY_PAYMENT)
                .account(fromAccount)
                .transactionId(transactionId)
                .referenceNumber(utilityPaymentRequest.getReferenceNumber())
                .amount(utilityPaymentRequest.getAmount().negate()).build());
        // İşlem detayları içeren bir yanıt döndür

        return UtilityPaymentResponse.builder().message("Hizmet ödemesi başarıyla tamamlandı").transactionId(transactionId).build();

    }
}
