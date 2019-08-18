package com.Debter.domain.Debter;

import com.Debter.domain.Transaction.domain.TransactionRepository;
import com.Debter.domain.User.domain.UserRepository;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DebeterFacadeCreator {

  @Autowired
  UserRepository userRepository;

  @Autowired
  TransactionRepository transactionRepository;

  public DebterFacade createDebeterFacade(TransactionRepository transactionRepository, UserRepository userRepository) {

    return DebterFacade.builder()
        .userRepository(userRepository)
        .transactionRepository(transactionRepository)
        .build();
  }

  @Bean
  DebterFacade createDebeterFacade() {

    return createDebeterFacade(transactionRepository, userRepository);
  }


}
