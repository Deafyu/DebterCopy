package com.Debter.domain.UserRelation.domain;

import com.Debter.domain.UserRelation.dto.UserRelationDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Getter
@Builder(toBuilder = true)
public class UserRelation {

  Long userId;
  Long userId2;
  Date date;
  Long relationId;

  @NonFinal
  @Setter
  boolean areFriends;

  static UserRelation fromDto(UserRelationDto dto) {

    return UserRelation.builder()
        .userId(dto.getUserId())
        .userId2(dto.getUserId2())
        .date(dto.getDate())
        .relationId(dto.getRelationId())
        .areFriends(dto.getAreFriends())
        .build();
  }

  public UserRelationDto dto() {

    return UserRelationDto.builder()
        .userId(userId)
        .userId2(userId2)
        .date(date)
        .areFriends(areFriends)
        .relationId(relationId)
        .build();
  }
}
