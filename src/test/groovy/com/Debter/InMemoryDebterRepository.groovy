package com.Debter

import com.Debter.domain.DebeterRepository
import com.Debter.domain.User
import com.Debter.domain.Transaction
import com.Debter.domain.UserRelation

import java.time.LocalDate

class InMemoryDebterRepository implements DebeterRepository {

    Map<Long, Transaction> transactions = new HashMap<>()

    Map<Long, User> users = new HashMap<>()

    Map<Long , UserRelation> userRelations = new HashMap<>()

    @Override
    Long createNewUser() {

        Random random = new Random()
        Long userId = random.nextLong()

        users.put(userId, User.builder()
                .userId(userId)
                .userFunds(0L)
                .accActive(true)
                .logedIn(false)
                .build()
        )

        return userId
    }

    @Override
    Optional<User> findUseById(Long userId) {

        return Optional.ofNullable(users.get(userId))
    }

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
    Long createNewRelation(Long userId, Long userId2, Date date) {

        Random random = new Random()
        Long relationId = random.nextLong()

        userRelations.put(relationId, UserRelation.builder()
                .relationId(relationId)
                .userId(userId)
                .userId2(userId2)
                .date(date)
                .areFriends(true)
                .build()
        )

        return relationId
    }

    @Override
    Optional<UserRelation> findRelationById(Long relationId) {

        return Optional.ofNullable(userRelations.get(relationId))
    }

    @Override
    void setAreFriendsStatus(Long relationId, boolean relationStatus) {
        userRelations.get(relationId).setAreFriends(relationStatus)
    }

    @Override
    void setTransactionsPayedBackStatus(Long transactionId, boolean payedBackStatus) {

        transactions.get(transactionId).setPayedBack(payedBackStatus)
    }

    @Override
    void setSingInStatus(Long userId, boolean singInStatus) {

        users.get(userId).setLogedIn(singInStatus)

    }
}
