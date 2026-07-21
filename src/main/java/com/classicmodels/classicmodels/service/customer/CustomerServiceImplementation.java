package com.classicmodels.classicmodels.service.customer;

import com.classicmodels.classicmodels.entities.Customer;
import com.classicmodels.classicmodels.repository.CustomerRepository;
import com.classicmodels.classicmodels.service.customer.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImplementation implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Integer customerNumber) {
        return customerRepository.findById(customerNumber)
                .orElse(null);
    }

    @Override
    public Customer updateCustomer(Integer customerNumber, Customer updatedCustomer) {

        Customer existingCustomer = customerRepository.findById(customerNumber)
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        existingCustomer.setCustomerName(updatedCustomer.getCustomerName());
        existingCustomer.setContactFirstName(updatedCustomer.getContactFirstName());
        existingCustomer.setContactLastName(updatedCustomer.getContactLastName());
        existingCustomer.setPhone(updatedCustomer.getPhone());
        existingCustomer.setAddressLine1(updatedCustomer.getAddressLine1());
        existingCustomer.setAddressLine2(updatedCustomer.getAddressLine2());
        existingCustomer.setCity(updatedCustomer.getCity());
        existingCustomer.setState(updatedCustomer.getState());
        existingCustomer.setPostalCode(updatedCustomer.getPostalCode());
        existingCustomer.setCountry(updatedCustomer.getCountry());
        existingCustomer.setSalesRepEmployeeNumber(updatedCustomer.getSalesRepEmployeeNumber());
        existingCustomer.setCreditLimit(updatedCustomer.getCreditLimit());

        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Integer customerNumber) {
        try {
            customerRepository.deleteById(customerNumber);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Cannot delete customer because it has related orders or payments."
            );
        }
    }

}
