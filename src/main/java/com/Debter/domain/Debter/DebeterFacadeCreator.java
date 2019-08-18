package com.Debter.domain.Debter;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DebeterFacadeCreator {

  @Autowired
  DebeterRepository debeterRepository;

  private DebterFacade createDebeterFacade(DebeterRepository debeterRepository) {

    return DebterFacade.builder()
        .debeterRepository(debeterRepository)
        .build();
  }

  @Bean
  DebterFacade createDebeterFacade() {

    return createDebeterFacade(debeterRepository);
  }


}
