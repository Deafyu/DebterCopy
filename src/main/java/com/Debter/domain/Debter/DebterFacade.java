package com.Debter.domain.Debter;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
class DebterFacade {

  DebeterRepository debeterRepository;

}
