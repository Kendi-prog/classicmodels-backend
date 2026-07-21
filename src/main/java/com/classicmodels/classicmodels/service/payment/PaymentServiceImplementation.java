package com.classicmodels.classicmodels.service.payment;

import com.classicmodels.classicmodels.entities.Payment;
import com.classicmodels.classicmodels.entities.PaymentId;
import com.classicmodels.classicmodels.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImplementation implements PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentServiceImplementation(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment getPaymentById(Integer customerNumber, String checkNumber) {
        PaymentId id = new PaymentId();
        id.setCustomerNumber(customerNumber);
        id.setCheckNumber(checkNumber);
        return paymentRepository.findById(id).orElse(null);
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment update(Integer customerNumber,
                          String checkNumber,
                          Payment updatedPayment) {

        PaymentId id = new PaymentId();
        id.setCustomerNumber(customerNumber);
        id.setCheckNumber(checkNumber);

        Payment existing = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));

        existing.setPaymentDate(updatedPayment.getPaymentDate());
        existing.setAmount(updatedPayment.getAmount());

        return paymentRepository.save(existing);
    }

    @Override
    public void delete(Integer customerNumber, String checkNumber) {

        PaymentId id = new PaymentId();
        id.setCustomerNumber(customerNumber);
        id.setCheckNumber(checkNumber);

        try {
            paymentRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Cannot delete payment because it is referenced by other records."
            );
        }
    }


}

