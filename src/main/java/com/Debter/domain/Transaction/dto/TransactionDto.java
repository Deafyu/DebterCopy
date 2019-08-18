package com.Debter.domain.Transaction.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@Getter
public class TransactionDto {

  Long lenderId;
  Long burrowerId;
  Long money;
  Date date;
  Long transactionId;

  @NonFinal
  @Setter
  boolean payedBack;

  public Long getTime() {
    return date.getTime();
  }

  public boolean getPayedBack() {
    return payedBack;
  }
}
