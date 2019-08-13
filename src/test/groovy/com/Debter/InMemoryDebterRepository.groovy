package com.Debter

import com.Debter.domain.DebeterRepository
import com.Debter.domain.User
import com.Debter.domain.Transaction

class InMemoryDebterRepository implements DebeterRepository {

    Map<Long, Transaction> transactions = new HashMap<>()

    Map<Long, User> users = new HashMap<>()

    void createNewUser(Long userId) {
        users.put(userId, User.builder().userId(userId).userFunds(0L).build())
    }

    Optional<User> findUseById(Long userId) {

        return Optional.ofNullable(users.get(userId))
    }
}
