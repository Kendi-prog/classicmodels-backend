package com.classicmodels.classicmodels.controller;

import com.classicmodels.classicmodels.entities.Customer;
import com.classicmodels.classicmodels.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<Customer> getCustomerById(
            @PathVariable Integer customerNumber) {

        Customer customer = customerService.getCustomerById(customerNumber);

        if (customer == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customer);
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.saveCustomer(customer));
    }

    @PutMapping("/{customerNumber}")
    public ResponseEntity<Customer> updateCustomer(
            @PathVariable Integer customerNumber,
            @RequestBody Customer customer) {

        Customer updated =
                customerService.updateCustomer(customerNumber, customer);

        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{customerNumber}")
    public ResponseEntity<?> deleteCustomer(
            @PathVariable Integer customerNumber) {

        try {
            customerService.deleteCustomer(customerNumber);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}

