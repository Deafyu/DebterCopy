package com.User

import com.Debter.domain.User.domain.User
import com.Debter.domain.User.domain.UserRepository

class InMemoryUserRepository implements UserRepository{

    Map<Long, User> users = new HashMap<>()

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
    Optional<User> findUserById(Long userId) {

        return Optional.ofNullable(users.get(userId))
    }

    @Override
    void setSingInStatus(Long userId, boolean singInStatus) {

        users.get(userId).setLogedIn(singInStatus)
    }

    @Override
    void setAccountActiveStatus(Long userId, boolean accountActiveStatus) {

        users.get(userId).setAccActive(accountActiveStatus)
    }
}
