package com.classicmodels.classicmodels.controller;

import com.classicmodels.classicmodels.entities.Payment;
import com.classicmodels.classicmodels.service.payment.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{customerNumber}/{checkNumber}")
    public Payment getPaymentById(
            @PathVariable Integer customerNumber,
            @PathVariable String checkNumber) {
        return paymentService.getPaymentById(customerNumber, checkNumber);
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        return paymentService.save(payment);
    }

    @PutMapping("/{customerNumber}/{checkNumber}")
    public Payment updatePayment(
            @PathVariable Integer customerNumber,
            @PathVariable String checkNumber,
            @RequestBody Payment payment) {

        return paymentService.update(customerNumber, checkNumber, payment);
    }

    @DeleteMapping("/{customerNumber}/{checkNumber}")
    public ResponseEntity<?> deletePayment(
            @PathVariable Integer customerNumber,
            @PathVariable String checkNumber) {

        try {
            paymentService.delete(customerNumber, checkNumber);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}

