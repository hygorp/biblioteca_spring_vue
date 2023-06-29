package com.hygorp.biblioteca.repository;

import com.hygorp.biblioteca.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
   Order findByClientId(Integer id);
}
