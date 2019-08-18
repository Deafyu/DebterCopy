package com.Debter.domain.User.domain;

import java.util.Optional;

public interface UserRepository {

  Long createNewUser();

  Optional<User> findUserById(Long userId);

  void setSingInStatus(Long userId, boolean singInStatus);

  void setAccountActiveStatus(Long userId, boolean accountActiveStatus);

  void addUserFunds(Long userId, Long funds);
}
