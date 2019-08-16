package com.Debter.domain;

import com.Debter.dto.UserRelationDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(toBuilder = true)
@Getter
public class UserRelation {

  Long userId;
  Long userId2;
  Date date;
  Long relationId;

  static UserRelation fromDto(UserRelationDto dto) {

    return UserRelation.builder()
        .userId(dto.getUserId())
        .userId2(dto.getUserId2())
        .date(dto.getDate())
        .relationId(dto.getRelationId())
        .build();
  }

  UserRelationDto dto() {

    return UserRelationDto.builder()
        .userId(userId)
        .userId2(userId2)
        .date(date)
        .relationId(relationId)
        .build();
  }
}
