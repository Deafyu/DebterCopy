package com.Debter.domain.Transaction.domain;

import com.Debter.domain.Transaction.dto.TransactionDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

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
  boolean payedBack;

  static Transaction fromDto(TransactionDto dto) {

    return Transaction.builder()
        .payedBack(dto.getPayedBack())
        .lenderId(dto.getLenderId())
        .burrowerId(dto.getBurrowerId())
        .money(dto.getMoney())
        .date(dto.getDate())
        .transactionId(dto.getTransactionId())
        .build();
  }

  public TransactionDto dto() {

    return TransactionDto.builder()
        .payedBack(payedBack)
        .money(money)
        .transactionId(transactionId)
        .burrowerId(burrowerId)
        .lenderId(lenderId)
        .date(date)
        .build();
  }

}
