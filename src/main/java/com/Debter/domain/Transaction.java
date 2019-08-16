package com.Debter.domain;

import com.Debter.dto.TransactionDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(toBuilder = true)
@Getter
@Setter
public class Transaction {

    Long lenderId;
    Long burrowerId;
    Long money;
    Long transactionId;
    Date date;
    boolean doneTransaction;

    static Transaction fromDto(TransactionDto dto){

        return Transaction.builder()
                .doneTransaction(dto.getAreFriends())
                .lenderId(dto.getLenderId())
                .burrowerId(dto.getBurrowerId())
                .money(dto.getMoney())
                .date(dto.getDate())
                .build();
    }

    TransactionDto dto(){

        return TransactionDto.builder()
                .areFriends(doneTransaction)
                .money(money)
                .burrowerId(burrowerId)
                .lenderId(lenderId)
                .date(date)
                .build();
    }

}
