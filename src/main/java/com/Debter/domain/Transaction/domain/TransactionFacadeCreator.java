package com.Debter.domain.Transaction.domain;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionFacadeCreator {

  @Autowired
  TransactionRepository transactionRepository;

  public TransactionFacade createTransactionFacade(TransactionRepository transactionRepository) {

    return TransactionFacade.builder()
        .transactionRepository(transactionRepository)
        .build();
  }

  @Bean
  TransactionFacade createUserRelationFacade() {

    return createTransactionFacade(transactionRepository);
  }

}
