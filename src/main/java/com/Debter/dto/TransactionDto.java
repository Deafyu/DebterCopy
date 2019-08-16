package com.Debter.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder
@Getter
public class TransactionDto {

    Long lenderId;
    Long burrowerId;
    Long money;
    boolean areFriends;
    Date date;

    public Long getTime(){
        return date.getTime();
    }
    public boolean getAreFriends(){
        return areFriends;
    }
}
