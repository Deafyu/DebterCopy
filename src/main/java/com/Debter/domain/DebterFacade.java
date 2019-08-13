package com.Debter.domain;

import com.Debter.dto.TransactionDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class DebterFacade {

    DebeterRepository debeterRepository;

    public void addNewTransaction(Long userId, Long userId2) {
    }

    public TransactionDto getTransaction(Long userId, Long userId2) {
    }
}
