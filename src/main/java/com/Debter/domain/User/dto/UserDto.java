package com.Debter.domain.User.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
public class UserDto {

  @Getter
  Long userId;

  @Getter
  @NonFinal
  @Setter
  Long userFunds;

  @NonFinal
  @Setter
  boolean accActive;

  @NonFinal
  @Setter
  boolean loggedIn;

  public boolean getLoggedIn() {
    return loggedIn;
  }

  public boolean getAccountActive() {
    return accActive;
  }
}
