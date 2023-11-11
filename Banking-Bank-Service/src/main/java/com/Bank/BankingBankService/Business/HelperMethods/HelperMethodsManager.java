package com.Bank.BankingBankService.Business.HelperMethods;

import com.Bank.BankingBankService.Business.Dto.BankAccount;
import com.Bank.BankingBankService.Core.exceptions.EntityNotFoundException;
import com.Bank.BankingBankService.Core.exceptions.GlobalErrorCode;
import com.Bank.BankingBankService.Core.exceptions.InsufficientFundsException;
import com.Bank.BankingBankService.DataAccess.BankAccountsRepository;
import com.Bank.BankingBankService.DataAccess.TransactionRepository;
import com.Bank.BankingBankService.Model.Entity.BankAccountEntity;
import com.Bank.BankingBankService.Model.Entity.TransactionEntity;
import com.Bank.BankingBankService.Model.Enum.TransactionType;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;
@Service
@AllArgsConstructor
public class HelperMethodsManager implements Helper{
    // Hesap bakiyesini kontrol etmek için yardımcı metod
    private final BankAccountsRepository bankAccountsRepository;
    private final TransactionRepository transactionRepository;
    @Override
    public void validateBalance(BankAccount bankAccount, BigDecimal amount) {
        if (bankAccount.getActualBalance().compareTo(BigDecimal.ZERO) < 0 || bankAccount.getActualBalance().compareTo(amount) < 0) {
            throw new InsufficientFundsException("Insufficient funds in the account " + bankAccount.getNumber(), GlobalErrorCode.INSUFFICIENT_FUNDS);
        }

    }

    @Override
    public String internalFundTransfer(BankAccount fromBankAccount, BankAccount toBankAccount, BigDecimal amount) {
        // Create a unique transaction ID
        String transactionId = UUID.randomUUID().toString();

        // Receive sender and receiver bank account entities ( Gönderici ve alıcı banka hesap varlıklarını al)
        BankAccountEntity fromBankAccountEntity = bankAccountsRepository.findByNumber(fromBankAccount.getNumber()).orElseThrow(EntityNotFoundException::new);
        BankAccountEntity toBankAccountEntity = bankAccountsRepository.findByNumber(toBankAccount.getNumber()).orElseThrow(EntityNotFoundException::new);

        // Update sender account balance after fund transfer( Fon transferinden sonra gönderici hesap bakiyesini güncelle)
        fromBankAccountEntity.setActualBalance(fromBankAccountEntity.getActualBalance().subtract(amount));
        fromBankAccountEntity.setAvailableBalance(fromBankAccountEntity.getActualBalance().subtract(amount));
        bankAccountsRepository.save(fromBankAccountEntity);

        // Save fund transfer transaction for sender( Gönderici için fon transferi işlemini kaydet)
        transactionRepository.save(TransactionEntity.builder().transactionType(TransactionType.FUND_TRANSFER)
                .referenceNumber(toBankAccountEntity.getNumber())
                .transactionId(transactionId)
                .account(fromBankAccountEntity).amount(amount.negate()).build());

        //Update recipient account balance(Alıcı hesap bakiyesini güncelle)
        toBankAccountEntity.setActualBalance(toBankAccountEntity.getActualBalance().add(amount));
        toBankAccountEntity.setAvailableBalance(toBankAccountEntity.getActualBalance().add(amount));
        bankAccountsRepository.save(toBankAccountEntity);

        // Save fund transfer transaction for the recipient (Alıcı için fon transferi işlemini kaydet)
        transactionRepository.save(TransactionEntity.builder().transactionType(TransactionType.FUND_TRANSFER)
                .referenceNumber(toBankAccountEntity.getNumber())
                .transactionId(transactionId)
                .account(toBankAccountEntity).amount(amount).build());
        return transactionId;
    }
}
