package com.Debter.domain;

import java.util.List;
import java.util.Optional;

public interface DebeterRepository {

    Long createNewUser();

    Optional<User> findUseById(Long userId);

    Long createNewTransaction(Long userId, Long userId2, Long money);

    Optional<Transaction> findTransactionById(Long transactionId);

    List<Transaction> getAllHistory(Long userId, Long userId2);
}
