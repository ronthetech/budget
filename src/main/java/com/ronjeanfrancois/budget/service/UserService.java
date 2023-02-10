package com.ronjeanfrancois.budget.service;

import com.ronjeanfrancois.budget.dto.UserDto;
import com.ronjeanfrancois.budget.model.UserEntity;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();
}
