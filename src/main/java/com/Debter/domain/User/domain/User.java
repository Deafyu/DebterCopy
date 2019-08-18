package com.Debter.domain.User.domain;

import com.Debter.domain.User.dto.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(toBuilder = true)
public class User {

  @Getter
  Long userId;

  @Getter
  Long userFunds;

  boolean accActive;

  boolean loggedIn;

  static User fromDto(UserDto dto) {

    return User.builder()
        .userFunds(dto.getUserFunds())
        .userId(dto.getUserId())
        .loggedIn(dto.getLoggedIn())
        .accActive(dto.getAccountActive())
        .build();
  }

  public UserDto dto() {

    return UserDto.builder()
        .userId(userId)
        .userFunds(userFunds)
        .loggedIn(loggedIn)
        .accActive(accActive)
        .build();
  }


}
