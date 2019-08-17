package com.Debter.domain;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface DebeterRepository {

  Long createNewUser();

  Optional<User> findUseById(Long userId);

  Long createNewTransaction(Long userId, Long userId2, Long money, Date date);

  Optional<Transaction> findTransactionById(Long transactionId);

  List<Transaction> getAllHistory(Long userId, Long userId2);

  Long createNewRelation(Long userId, Long userId2, Date date);

  Optional<UserRelation> findRelationById(Long relationId);

  void setAreFriendsStatus(Long relationId, boolean relationStatus);

  void setTransactionsPayedBackStatus(Long transactionId, boolean payedBackStatus);

  void setSingInStatus(Long userId, boolean singInStatus);
}
