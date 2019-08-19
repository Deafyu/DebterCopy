package com.Debter.domain.User.domain;

import com.Debter.domain.User.dto.UserDto;
import com.Debter.domain.User.exceptions.UserNotFoundException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.Random;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class UserFacade {

  UserRepository userRepository;


  public Long addNewUser() {
    Random random = new Random();
    Long userId = random.nextLong();

    userRepository.save(User.builder()
        .userId(userId)
        .userFunds(0L)
        .accActive(true)
        .loggedIn(false)
        .build()
    );

    return userId;
  }

  public UserDto getUser(Long userId) throws UserNotFoundException {
    return userRepository.findById(userId)
        .orElseThrow(() -> new UserNotFoundException("User: " + userId + " not found"))
        .dto();
  }

  public void logInUser(Long userId, boolean loggedInStatus) throws UserNotFoundException {
    UserDto dto = getUser(userId);
    dto.setLoggedIn(loggedInStatus);
    userRepository.save(User.fromDto(dto));
  }

  public void deactivateAccount(Long userId, boolean accountActiveStatus) throws UserNotFoundException {
    UserDto dto = getUser(userId);
    dto.setAccActive(accountActiveStatus);
    userRepository.save(User.fromDto(dto));
  }

  public void addFunds(Long userId, Long funds) throws UserNotFoundException {
    UserDto dto = getUser(userId);
    dto.setUserFunds(dto.getUserFunds() + funds);
    userRepository.save(User.fromDto(dto));
  }

  public void removeFunds(Long userId, Long funds) throws UserNotFoundException {
    UserDto dto = getUser(userId);
    dto.setUserFunds(dto.getUserFunds() - funds);
    userRepository.save(User.fromDto(dto));
  }
}
