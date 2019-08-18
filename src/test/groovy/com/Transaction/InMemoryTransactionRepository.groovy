package com.Transaction

import com.Debter.domain.Transaction.domain.Transaction
import com.Debter.domain.Transaction.domain.TransactionRepository

class InMemoryTransactionRepository implements TransactionRepository {

    Map<Long, Transaction> transactions = new HashMap<>()

    @Override
    void saveTransaction(Transaction transaction) {
        transactions.put(transaction.getTransactionId(),transaction)
    }

    @Override
    Optional<Transaction> findTransactionById(Long transactionId) {

        return Optional.ofNullable(transactions.get(transactionId))
    }

    @Override
    List<Transaction> getAllHistory(Long userId, Long userId2) {

        return new ArrayList<Transaction>(transactions.values())
    }

}
