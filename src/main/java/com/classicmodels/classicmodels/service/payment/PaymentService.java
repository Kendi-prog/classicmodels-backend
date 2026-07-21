package com.classicmodels.classicmodels.service.payment;

import com.classicmodels.classicmodels.entities.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getAllPayments();
    Payment getPaymentById(Integer customerNumber, String checkNumber);
    Payment save(Payment payment);
    Payment update(Integer customerNumber, String checkNumber, Payment payment);
    void delete(Integer customerNumber, String checkNumber);
}

