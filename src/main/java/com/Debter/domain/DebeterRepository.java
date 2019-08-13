package com.Debter.domain;

import com.Debter.dto.UserDto;

import java.util.Optional;

public interface DebeterRepository {

    void createNewUser(Long userId);

    Optional<User> findUseById(Long userId);
}
