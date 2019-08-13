package com.Debter.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Builder(access = AccessLevel.PACKAGE)
public class DebterFacade {

    DebeterRepository debeterRepository;

    public void addNewBurrower(Long userId , Long burrowerId) {
    }

    public void addNewLender(Long userId , Long lenderId) {
    }
}
