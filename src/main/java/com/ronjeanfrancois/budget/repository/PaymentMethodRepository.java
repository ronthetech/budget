package com.ronjeanfrancois.budget.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronjeanfrancois.budget.model.PaymentMethod;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long>{
  PaymentMethod findByName(String name);
}
