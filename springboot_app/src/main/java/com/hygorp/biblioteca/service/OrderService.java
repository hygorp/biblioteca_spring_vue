package com.hygorp.biblioteca.service;

import com.hygorp.biblioteca.domain.Order;
import com.hygorp.biblioteca.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findByClientId(Integer id){
        return orderRepository.findByClientId(id);
    }
}
