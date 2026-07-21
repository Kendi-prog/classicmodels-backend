package com.classicmodels.classicmodels.service.customer;

import com.classicmodels.classicmodels.entities.Customer;

import java.util.List;

public interface CustomerService {
    Customer saveCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer updateCustomer(Integer customerNumber, Customer customer);
    void deleteCustomer(Integer customerNumber);
    Customer getCustomerById(Integer customerNumber);
}
