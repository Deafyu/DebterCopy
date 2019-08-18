package com.Debter.domain.UserRelation.domain;

import java.util.Date;
import java.util.Optional;

public interface UserRelationRepository {

  Long createNewRelation(Long userId, Long userId2, Date date);

  Optional<UserRelation> findRelationById(Long relationId);

  void setAreFriendsStatus(Long relationId, boolean relationStatus);
}
