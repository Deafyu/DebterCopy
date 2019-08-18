package com.Debter.domain.User.domain;

import com.Debter.domain.User.dto.UserDto;
import com.Debter.domain.User.exceptions.UserNotFoundException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class UserFacade {

  UserRepository userRepository;


  public Long addNewUser() {

    return userRepository.createNewUser();

  }

  public UserDto getUser(Long userId) throws UserNotFoundException {

    return userRepository.findUserById(userId)
        .orElseThrow(() -> new UserNotFoundException("User: " + userId + " not found"))
        .dto();
  }

  public void logInUser(Long userId, boolean singInStatus) {

    userRepository.findUserById(userId).ifPresent(user -> userRepository.setSingInStatus(userId, singInStatus));
  }

  public void deactivateAccount(Long userId, boolean accountActiveStatus) {

    userRepository.findUserById(userId).ifPresent(user -> userRepository.setAccountActiveStatus(userId, accountActiveStatus));
  }

  public void addFunds(Long userId, Long funds) {
    userRepository.findUserById(userId).ifPresent(user -> userRepository.addUserFunds(userId, funds));
  }

  public void removeFunds(Long userId, Long funds) {
    userRepository.findUserById(userId).ifPresent(user -> userRepository.removeUserFunds(userId, funds));
  }
}
