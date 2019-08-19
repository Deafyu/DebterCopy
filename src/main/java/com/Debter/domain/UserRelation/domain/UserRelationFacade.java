package com.Debter.domain.UserRelation.domain;

import com.Debter.domain.UserRelation.dto.UserRelationDto;
import com.Debter.domain.UserRelation.exceptions.UserRelationNotFoundException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.Random;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class UserRelationFacade {

  UserRelationRepository userRelationRepository;

  public Long addNewRelation(Long userId, Long userId2) {
    Random random = new Random();
    Long relationId = random.nextLong();

    userRelationRepository.save(UserRelation.builder()
        .relationId(relationId)
        .userId(userId)
        .userId2(userId2)
        .date(new Date())
        .areFriends(true)
        .build()
    );

    return relationId;
  }

  public UserRelationDto findRelationById(Long relationId) throws UserRelationNotFoundException {

    return userRelationRepository.findById(relationId)
        .orElseThrow(() -> new UserRelationNotFoundException("UserRelation: " + relationId + " not found"))
        .dto();
  }

  public void setFriendStatus(Long relationId, boolean relationStatus) throws UserRelationNotFoundException {
    UserRelationDto dto = findRelationById(relationId);
    dto.setAreFriends(relationStatus);
    userRelationRepository.save(UserRelation.fromDto(dto));
  }
}
