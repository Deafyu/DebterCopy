package com.Debter.domain.Debter;

import com.Debter.domain.Transaction.domain.TransactionRepository;
import com.Debter.domain.User.domain.UserRepository;
import com.Debter.domain.User.dto.UserDto;
import com.Debter.domain.User.exceptions.UserNotFoundException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class DebterFacade {

  UserRepository userRepository;

  TransactionRepository transactionRepository;


  public boolean checkFunds(Long userId, Long funds) throws UserNotFoundException {

    UserDto userDto = userRepository.findById(userId)
        .orElseThrow(() -> new UserNotFoundException("User: " + userId + " not found"))
        .dto();

    return userDto.getUserFunds() - funds >= 0;
  }
}
