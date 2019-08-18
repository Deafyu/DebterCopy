package com.Debter.domain.UserRelation.domain;

import com.Debter.domain.UserRelation.dto.UserRelationDto;
import com.Debter.domain.UserRelation.exceptions.UserRelationNotFoundException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class UserRelationFacade {

  UserRelationRepository userRelationRepository;

  public Long addNewRelation(Long userId, Long userId2) {

    return userRelationRepository.createNewRelation(userId, userId2, new Date());
  }

  public UserRelationDto getRelation(Long relationId) throws UserRelationNotFoundException {

    return userRelationRepository.findRelationById(relationId)
        .orElseThrow(() -> new UserRelationNotFoundException("UserRelation: " + relationId + " not found"))
        .dto();
  }

  public void setUserRelation(Long relationId, boolean relation) {

    userRelationRepository.findRelationById(relationId).ifPresent(userRelation -> userRelationRepository.setAreFriendsStatus(relationId, relation));
  }
}
