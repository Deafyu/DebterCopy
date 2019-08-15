package com.Debter.domain;

import com.Debter.dto.TransactionDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(toBuilder = true)
@Getter
public class Transaction {

    Long lenderId;
    Long burrowerId;
    Long money;
    Long transactionId;
    Date date;

    static Transaction fromDto(TransactionDto dto){

        return Transaction.builder()
                .transactionId(dto.getTransactionId())
                .lenderId(dto.getLenderId())
                .burrowerId(dto.getBurrowerId())
                .money(dto.getMoney())
                .date(dto.getDate())
                .build();
    }

    TransactionDto dto(){

        return TransactionDto.builder()
                .transactionId(transactionId)
                .money(money)
                .burrowerId(burrowerId)
                .lenderId(lenderId)
                .date(date)
                .build();
    }

}
