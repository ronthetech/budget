package com.ronjeanfrancois.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronjeanfrancois.budget.model.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
  Optional<UserEntity> findByUsername(String username);
  Boolean existsByUsername(String username);
}

