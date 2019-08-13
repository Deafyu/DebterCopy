package com.Debter

import com.Debter.domain.DebeterRepository
import com.Debter.domain.DefaultUser
import com.Debter.domain.Transaction

class InMemoryDebterRepository implements DebeterRepository {

    Map<Integer, Transaction> transactions = new HashMap<>()

    Map<Integer, DefaultUser> users = new HashMap<>()

    void saveBurrower(Long userId, Long burrowerId) {

    }

    void saveLender(Long userId, Long lenderId) {

    }
}
