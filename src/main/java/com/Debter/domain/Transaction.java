package com.Debter.domain;

import com.Debter.dto.TransactionDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(toBuilder = true)
@Getter
public class Transaction {

    Long lenderId;
    Long burrowerId;
    Long money;
    Long transactionId;

    static Transaction fromDto(TransactionDto dto){

        return Transaction.builder()
                .transactionId(dto.getTransactionId())
                .lenderId(dto.getLenderId())
                .burrowerId(dto.getBurrowerId())
                .money(dto.getMoney())
                .build();
    }

    TransactionDto dto(){

        return TransactionDto.builder()
                .transactionId(transactionId)
                .money(money)
                .burrowerId(burrowerId)
                .lenderId(lenderId)
                .build();
    }

}
