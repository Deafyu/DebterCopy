package com.Debter.domain.Transaction.domain;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

  Long createNewTransaction(Long userId, Long userId2, Long money, Date date);

  Optional<Transaction> findTransactionById(Long transactionId);

  List<Transaction> getAllHistory(Long userId, Long userId2);

  void setTransactionsPayedBackStatus(Long transactionId, boolean payedBackStatus);
}
