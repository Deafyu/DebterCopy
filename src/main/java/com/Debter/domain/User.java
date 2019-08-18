package com.Debter.domain;

import com.Debter.dto.UserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(toBuilder = true)
public class User {

  @Getter
  Long userId;

  @Getter
  @NonFinal
  Long userFunds;


  @Setter
  @NonFinal
  boolean accActive;

  @Setter
  @NonFinal
  boolean logedIn;

  static User fromDto(UserDto dto) {

    return User.builder()
        .userFunds(dto.getUserFunds())
        .logedIn(dto.getLogedIn())
        .accActive(dto.getAccountActive())
        .build();
  }

  UserDto dto() {

    return UserDto.builder()
        .userFunds(userFunds)
        .logedIn(logedIn)
        .accActive(accActive)
        .build();
  }


}
