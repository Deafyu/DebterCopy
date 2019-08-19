package com.Debter.domain.Transaction.domain;

import com.Debter.domain.Transaction.dto.TransactionDto;
import com.Debter.domain.Transaction.exceptions.TransactionNotFoundException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.*;
import java.util.stream.Collectors;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class TransactionFacade {

  TransactionRepository transactionRepository;

  public Long addNewTransaction(Long lenderId, Long burrowerId, Long money) {

    Random random = new Random();
    Long transactionId = random.nextLong();

    transactionRepository.save(Transaction.builder()
        .transactionId(transactionId)
        .date(new Date())
        .burrowerId(burrowerId)
        .lenderId(lenderId)
        .money(money)
        .payedBack(false)
        .build()
    );

    return transactionId;
  }

  public TransactionDto findTransactionById(Long transactionId) throws TransactionNotFoundException {

    return transactionRepository.findById(transactionId)
        .orElseThrow(() -> new TransactionNotFoundException("Transaction :" + transactionId + " not found"))
        .dto();
  }

  public List<TransactionDto> getHistoryOfTransactions(Long userId, Long userId2) {

    List<Transaction> transactions = transactionRepository.getAllHistory(userId, userId2);
    List<TransactionDto> transactionsDto = new ArrayList<>();

    transactions.forEach(transaction -> transactionsDto.add(transaction.dto()));

    for (int i = 0; i < transactionsDto.size(); i++) {
      if (!transactionsDto.get(i).getLenderId().equals(userId) || !transactionsDto.get(i).getBurrowerId().equals(userId2)) {
        if (!transactionsDto.get(i).getLenderId().equals(userId2) || !transactionsDto.get(i).getBurrowerId().equals(userId)) {
          transactionsDto.remove(i);
          i--;
        }
      }
    }

    return transactionsDto;
  }

  public List<TransactionDto> sortHistoryByDate(List<TransactionDto> dto) {

    return dto.stream()
        .sorted(Comparator.comparingLong(TransactionDto::getTime).reversed())
        .collect(Collectors.toList());
  }

  public void changePayedBackStatus(Long transactionId, boolean payedBackStatus) throws TransactionNotFoundException {

    TransactionDto dto = findTransactionById(transactionId);
    dto.setPayedBack(payedBackStatus);
    transactionRepository.save(Transaction.fromDto(dto));
  }
}
