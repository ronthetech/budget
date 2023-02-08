package com.ronjeanfrancois.budget.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronjeanfrancois.budget.model.PaymentMethod;
import com.ronjeanfrancois.budget.repository.PaymentMethodRepository;

@RestController
@RequestMapping("/api")
public class PaymentMethodController {

  private PaymentMethodRepository paymentMethodRepository;

  public PaymentMethodController(PaymentMethodRepository paymentMethodRepository) {
    this.paymentMethodRepository = paymentMethodRepository;
  }

  @GetMapping("/payment-methods")
  public List<PaymentMethod> getAllPaymentMethods() {
    return paymentMethodRepository.findAll();
  }

  @PostMapping("/payment-methods")
  public PaymentMethod createPaymentMethod(@RequestBody PaymentMethod paymentMethod) {
    return paymentMethodRepository.save(paymentMethod);
  }

  @PutMapping("/payment-methods/{id}")
  public PaymentMethod updatePaymentMethod(@PathVariable Long id, @RequestBody PaymentMethod paymentMethod) {
    paymentMethod.setId(id);
    return paymentMethodRepository.save(paymentMethod);
  }

  @DeleteMapping("/payment-methods/{id}")
  public void deletePaymentMethod(@PathVariable Long id) {
    paymentMethodRepository.deleteById(id);
  }
}

