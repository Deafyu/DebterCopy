package com.Debter.domain.UserRelation.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@Getter
public class UserRelationDto {

  Long userId;
  Long userId2;
  Date date;
  Long relationId;

  @Setter
  @NonFinal
  boolean areFriends;

  public boolean getAreFriends() {
    return areFriends;
  }
}
