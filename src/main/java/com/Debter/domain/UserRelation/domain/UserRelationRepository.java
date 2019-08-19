package com.Debter.domain.UserRelation.domain;

import com.Debter.domain.User.domain.User;
import com.Debter.domain.User.domain.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.Optional;

public interface UserRelationRepository extends JpaRepository<UserRelation, Long> {

}
