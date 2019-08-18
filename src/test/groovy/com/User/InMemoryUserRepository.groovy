package com.User

import com.Debter.domain.User.domain.User
import com.Debter.domain.User.domain.UserRepository

class InMemoryUserRepository implements UserRepository{

    Map<Long, User> users = new HashMap<>()

    @Override
    Optional<User> findUserById(Long userId) {

        return Optional.ofNullable(users.get(userId))
    }

    @Override
    void saveUser(User user) {
        users.put(user.getUserId(),user)
    }
}
