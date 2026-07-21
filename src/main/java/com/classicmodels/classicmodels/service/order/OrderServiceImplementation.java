package com.classicmodels.classicmodels.service.order;

import com.classicmodels.classicmodels.entities.Order;
import com.classicmodels.classicmodels.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImplementation implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImplementation(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order update(Integer id, Order updatedOrder) {
        Order existingOrder = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));

        existingOrder.setOrderDate(updatedOrder.getOrderDate());
        existingOrder.setRequiredDate(updatedOrder.getRequiredDate());
        existingOrder.setShippedDate(updatedOrder.getShippedDate());
        existingOrder.setStatus(updatedOrder.getStatus());
        existingOrder.setComments(updatedOrder.getComments());
        existingOrder.setCustomer(updatedOrder.getCustomer());

        return orderRepository.save(existingOrder);
    }

    @Override
    public void delete(Integer id) {
        try {
            orderRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(
                    "Cannot delete order because it has related order details."
            );
        }
    }

}

