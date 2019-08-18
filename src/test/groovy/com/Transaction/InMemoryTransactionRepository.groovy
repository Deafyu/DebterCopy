package com.Transaction

import com.Debter.domain.Transaction.domain.Transaction
import com.Debter.domain.Transaction.domain.TransactionRepository

class InMemoryTransactionRepository implements TransactionRepository {

    Map<Long, Transaction> transactions = new HashMap<>()

    @Override
    Long createNewTransaction(Long userId, Long userId2, Long money, Date date) {

        Random random = new Random()
        Long transactionId = random.nextLong()

        transactions.put(transactionId, Transaction.builder()
                .lenderId(userId)
                .burrowerId(userId2)
                .money(money)
                .date(date)
                .transactionId(transactionId)
                .payedBack(false)
                .build()
        )

        return transactionId
    }

    @Override
    Optional<Transaction> findTransactionById(Long transactionId) {

        return Optional.ofNullable(transactions.get(transactionId))
    }

    @Override
    List<Transaction> getAllHistory(Long userId, Long userId2) {

        List<Transaction> list = new ArrayList<Transaction>(transactions.values())

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLenderId() != userId || list.get(i).getBurrowerId() != userId2) {
                if (list.get(i).getLenderId() != userId2 || list.get(i).getBurrowerId() != userId) {
                    list.remove(i)
                    i--
                }
            }
        }

        return list
    }

    @Override
    void setTransactionsPayedBackStatus(Long transactionId, boolean payedBackStatus) {

        transactions.get(transactionId).setPayedBack(payedBackStatus)
    }
}
