package com.Debter.domain;

import com.Debter.dto.UserDto;
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

    static User fromDto(UserDto dto){

        return User.builder()
                .userId(dto.getUserId())
                .build();
    }

    UserDto dto(){

        return UserDto.builder()
                .userId(userId)
                .build();
    }


}
