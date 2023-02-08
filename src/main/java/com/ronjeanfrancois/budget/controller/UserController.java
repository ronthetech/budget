package com.ronjeanfrancois.budget.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronjeanfrancois.budget.model.UserEntity;
import com.ronjeanfrancois.budget.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/users")
  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/users/{userName}")
  public UserEntity getUserByUserName(@PathVariable String userName) {
    return userRepository.findByUserName(userName);
  }

  @PostMapping("/users")
  public UserEntity createUser(@RequestBody UserEntity user) {
    return userRepository.save(user);
  }

  @PutMapping("/{id}")
  public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity user) {
    user.setId(id);
    return userRepository.save(user);
  }

  @DeleteMapping("/{id}")
  public void deleteUser(@PathVariable Long id) {
    userRepository.deleteById(id);
  }
}
