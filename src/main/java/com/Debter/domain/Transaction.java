package com.Debter.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(toBuilder = true)
public class Transaction {
}
