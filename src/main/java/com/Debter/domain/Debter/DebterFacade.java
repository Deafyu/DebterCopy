package com.Debter.domain.Debter;

import com.Debter.domain.Transaction.domain.TransactionRepository;
import com.Debter.domain.User.domain.UserRepository;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class DebterFacade {

  UserRepository userRepository;

  TransactionRepository transactionRepository;

}
