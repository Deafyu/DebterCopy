package com.Debter.domain.Transaction.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

  List<Transaction> getAllHistory(Long userId, Long userId2);

}
