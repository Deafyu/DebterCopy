package com.Debter.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@Getter
public class TransactionDto {

    Long lenderId;
    Long burrowerId;
    Long money;
    Long transactionId;
    Long date;
}
