package com.Debter.domain.UserRelation.domain;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRelationFacadeCreator {

  @Autowired
  UserRelationRepository userRelationRepository;

  public UserRelationFacade createUserRelationFacade(UserRelationRepository userRelationRepository) {

    return UserRelationFacade.builder()
        .userRelationRepository(userRelationRepository)
        .build();

  }

  @Bean
  UserRelationFacade createUserRelationFacade() {

    return createUserRelationFacade(userRelationRepository);
  }

}
