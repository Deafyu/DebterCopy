package com.Debter

import com.Debter.domain.DebeterRepository
import com.Debter.domain.User
import com.Debter.domain.Transaction

import java.util.stream.Collectors

class InMemoryDebterRepository implements DebeterRepository {

    Map<Long, Transaction> transactions = new HashMap<>()

    Map<Long, User> users = new HashMap<>()

    @Override
    Long createNewUser() {

        Random random = new Random()
        Long userId = random.nextLong()

        users.put(userId, User.builder()
                .userId(userId)
                .userFunds(0L)
                .build()
        )

        return userId
    }

    @Override
    Optional<User> findUseById(Long userId) {

        return Optional.ofNullable(users.get(userId))
    }

    @Override
    Long createNewTransaction(Long userId, Long userId2, Long money , Date date) {

        Random random = new Random()
        Long transactionId = random.nextLong()

        transactions.put(transactionId, Transaction.builder()
                .lenderId(userId)
                .burrowerId(userId2)
                .money(money)
                .date(date)
                .transactionId(transactionId)
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
            if (list.get(i).getLenderId() != userId || list.get(i).getBurrowerId() != userId2){
                if(list.get(i).getLenderId() != userId2 || list.get(i).getBurrowerId() != userId){
                    list.remove(i)
                    i--
                }
            }
        }

        return list
    }
}
