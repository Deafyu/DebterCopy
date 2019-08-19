package com.Debter.domain.User.domain;

import java.util.Optional;

public interface UserRepository {

  Optional<User> findUserById(Long userId);

  void saveUser(User user);
}
