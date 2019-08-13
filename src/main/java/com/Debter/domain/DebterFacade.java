package com.Debter.domain;

import com.Debter.dto.TransactionDto;
import com.Debter.dto.UserDto;
import com.Debter.exceptions.UserNotFoundException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.Random;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class DebterFacade {

    DebeterRepository debeterRepository;

    public void addNewTransaction(Long userId, Long userId2) {
    }

    public TransactionDto getTransaction(Long userId, Long userId2) {
        return null;
    }

    public Long addNewUser() {

        Random random = new Random();
        Long userId = random.nextLong();

        debeterRepository.createNewUser(userId);
        return userId;

    }

    public UserDto getUser(Long userId) throws UserNotFoundException {

        return debeterRepository.findUseById(userId)
                .orElseThrow(() -> new UserNotFoundException("User: "+ userId +" not found"))
                .dto();
    }
}
