package com.ronjeanfrancois.budget.controller;

import java.util.List;
import java.util.Optional;

import com.ronjeanfrancois.budget.dto.UserDto;
import com.ronjeanfrancois.budget.exceptions.DataNotFoundException;
import com.ronjeanfrancois.budget.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ronjeanfrancois.budget.model.UserEntity;
import com.ronjeanfrancois.budget.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

  private UserRepository userRepository;
  private UserService userService;

  @Autowired
  public UserController(UserRepository userRepository, UserService userService) {
    this.userRepository = userRepository;
    this.userService = userService;
  }

  @GetMapping("/users")
  public ResponseEntity<List<UserDto>> getAllUsers() {
    return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
  }

  @GetMapping("/users/{id}")
  public Optional<UserEntity> getUserById(@PathVariable Long id) {
    return Optional.ofNullable(userRepository.findById(id).orElseThrow(() -> new DataNotFoundException("User could not be found.")));
  }

  @PostMapping("/users")
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
    return new ResponseEntity<>(userService.createUser(userDto), HttpStatus.CREATED);
  }

  @PutMapping("/users/{id}")
  public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
    user.setId(id);
    return userRepository.save(user);
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable Long id) {
    userRepository.deleteById(id);
  }
}
