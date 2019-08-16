package com.Debter.domain;

import com.Debter.dto.TransactionDto;
import com.Debter.dto.UserDto;
import com.Debter.exceptions.TransactionNotFoundException;
import com.Debter.exceptions.UserNotFoundException;
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
public class DebterFacade {

  DebeterRepository debeterRepository;

  public Long addNewTransaction(Long lenderId, Long burrowerId, Long money) {

    return debeterRepository.createNewTransaction(lenderId, burrowerId, money, new Date());
  }

  public TransactionDto getTransaction(Long transactionId) throws TransactionNotFoundException {

    return debeterRepository.findTransactionById(transactionId)
        .orElseThrow(() -> new TransactionNotFoundException("Transaction :" + transactionId + " not found"))
        .dto();
  }

  public Long addNewUser() {

    return debeterRepository.createNewUser();

  }

  public UserDto getUser(Long userId) throws UserNotFoundException {

    return debeterRepository.findUseById(userId)
        .orElseThrow(() -> new UserNotFoundException("User: " + userId + " not found"))
        .dto();
  }

  public List<TransactionDto> getEntireHistoryOfTransactions(Long userId, Long userId2) {

    List<Transaction> transactions = debeterRepository.getAllHistory(userId, userId2);
    List<TransactionDto> transactionsDto = new ArrayList<>();

    transactions.forEach(transaction -> transactionsDto.add(transaction.dto()));

    return transactionsDto;
  }

  public List<TransactionDto> sortHistoryByDate(List<TransactionDto> dto) {

        return dto.stream()
        .sorted(Comparator.comparingLong(TransactionDto::getTime).reversed())
        .collect(Collectors.toList());
  }

}
