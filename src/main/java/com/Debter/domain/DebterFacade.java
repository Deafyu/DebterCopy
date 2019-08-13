package com.Debter.domain;

import com.Debter.dto.TransactionDto;
import com.Debter.dto.UserDto;
import com.Debter.exceptions.TransactionNotFoundException;
import com.Debter.exceptions.UserNotFoundException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Random;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class DebterFacade {

    DebeterRepository debeterRepository;

    public Long addNewTransaction(Long userId, Long userId2, Long money) {

        return debeterRepository.createNewTransaction(userId, userId2, money);
    }

    public TransactionDto getTransaction(Long transactionId) throws TransactionNotFoundException {

        return debeterRepository.findTransactionById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException("Transaction :" + transactionId + " not found"))
                .dto();
    }

    public Long addNewUser() {

        return debeterRepository.createNewUser();

    }

    public UserDto getUser(Long userId) throws UserNotFoundException {

        return debeterRepository.findUseById(userId)
                .orElseThrow(() -> new UserNotFoundException("User: " + userId + " not found"))
                .dto();
    }

    public List<TransactionDto> getEntireHistoryOfTransactions(Long userId, Long userId2) {

        debeterRepository.getAllHistory(userId,userId2);

        return null;
    }
}
