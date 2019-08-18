package com.Debter.domain.UserRelation.domain;

import com.Debter.domain.User.domain.User;
import com.Debter.domain.User.domain.UserRepository;

import java.util.Date;
import java.util.Optional;

public interface UserRelationRepository {

  Optional<UserRelation> findRelationById(Long relationId);

  void saveUserRelation(UserRelation relation);
}
