package com.Debter.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
public class UserDto {

  @Getter
  Long userId;

  @Getter
  Long userFunds;

  boolean accActive;

  boolean logedIn;

  public boolean getLogedIn() {
    return logedIn;
  }

  public boolean getAccountActive() {
    return accActive;
  }
}
