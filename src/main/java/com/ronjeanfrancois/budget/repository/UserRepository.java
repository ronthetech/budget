package com.ronjeanfrancois.budget.repository;

import java.util.List;

import com.ronjeanfrancois.budget.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ronjeanfrancois.budget.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByUserName(String userName);
}

