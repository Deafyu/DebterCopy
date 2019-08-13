package com.Debter.domain;

import com.Debter.dto.DefaultUserDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(toBuilder = true)
public class DefaultUser {

    @Getter
    Long userId;

    static DefaultUser fromDto(DefaultUserDto dto){

        return DefaultUser.builder()
                .userId(dto.getUserId())
                .build();
    }

    DefaultUserDto dto(){

        return DefaultUserDto.builder()
                .userId(userId)
                .build();
    }


}
