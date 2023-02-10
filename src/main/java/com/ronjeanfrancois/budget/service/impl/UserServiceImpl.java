package com.ronjeanfrancois.budget.service.impl;

import com.ronjeanfrancois.budget.dto.UserDto;
import com.ronjeanfrancois.budget.model.UserEntity;
import com.ronjeanfrancois.budget.repository.UserRepository;
import com.ronjeanfrancois.budget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto){
        UserEntity user = new UserEntity();
        user.setUserName(user.getUserName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());

        UserEntity newUser = userRepository.save(user);

        UserDto userResponse = new UserDto();
        userResponse.setId(newUser.getId());
        userResponse.setEmail(newUser.getEmail());
        userResponse.setPassword(newUser.getPassword());

        return userResponse;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> user = userRepository.findAll();
        return user.stream().map(u -> mapToDto(u)).collect(Collectors.toList());
    }

    private UserDto mapToDto(UserEntity user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setExpenses(user.getExpenses());
        userDto.setBudgets(user.getBudgets());
        return userDto;
    }

    private UserEntity mapToEntity(UserDto userDto){
        UserEntity user = new UserEntity();
        user.setId(userDto.getId());
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setExpenses(userDto.getExpenses());
        user.setBudgets(userDto.getBudgets());
        return user;
    }
}
