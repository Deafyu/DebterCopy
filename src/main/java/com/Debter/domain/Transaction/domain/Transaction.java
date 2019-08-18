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
@Setter
public class Transaction {

  Long lenderId;
  Long burrowerId;
  Long money;
  Long transactionId;
  Date date;

  @Setter
  @NonFinal
  boolean payedBack;

  static Transaction fromDto(TransactionDto dto) {

    return Transaction.builder()
        .payedBack(dto.getPayedBack())
        .lenderId(dto.getLenderId())
        .burrowerId(dto.getBurrowerId())
        .money(dto.getMoney())
        .date(dto.getDate())
        .build();
  }

  public TransactionDto dto() {

    return TransactionDto.builder()
        .payedBack(payedBack)
        .money(money)
        .burrowerId(burrowerId)
        .lenderId(lenderId)
        .date(date)
        .build();
  }

}
