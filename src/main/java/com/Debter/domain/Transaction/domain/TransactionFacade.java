package com.Debter.domain.Transaction.domain;

import com.Debter.domain.Transaction.dto.TransactionDto;
import com.Debter.domain.Transaction.exceptions.TransactionNotFoundException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class TransactionFacade {

  TransactionRepository transactionRepository;

  public Long addNewTransaction(Long lenderId, Long burrowerId, Long money) {

    return transactionRepository.createNewTransaction(lenderId, burrowerId, money, new Date());
  }

  public TransactionDto getTransaction(Long transactionId) throws TransactionNotFoundException {

    return transactionRepository.findTransactionById(transactionId)
        .orElseThrow(() -> new TransactionNotFoundException("Transaction :" + transactionId + " not found"))
        .dto();
  }

  public List<TransactionDto> getEntireHistoryOfTransactions(Long userId, Long userId2) {

    List<Transaction> transactions = transactionRepository.getAllHistory(userId, userId2);
    List<TransactionDto> transactionsDto = new ArrayList<>();

    transactions.forEach(transaction -> transactionsDto.add(transaction.dto()));

    return transactionsDto;
  }

  public List<TransactionDto> sortHistoryByDate(List<TransactionDto> dto) {

    return dto.stream()
        .sorted(Comparator.comparingLong(TransactionDto::getTime).reversed())
        .collect(Collectors.toList());
  }

  public void payTransaction(Long transactionId, boolean payedBackStatus) {

    transactionRepository.findTransactionById(transactionId).ifPresent(transaction -> transactionRepository.setTransactionsPayedBackStatus(transactionId, payedBackStatus));
  }
}
