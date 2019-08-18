package com.Debter.domain.Transaction.domain;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository {

  void saveTransaction(Transaction transaction);

  Optional<Transaction> findTransactionById(Long transactionId);

  List<Transaction> getAllHistory(Long userId, Long userId2);

}
