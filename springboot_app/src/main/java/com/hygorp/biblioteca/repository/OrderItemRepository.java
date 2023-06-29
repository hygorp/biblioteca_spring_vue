package com.hygorp.biblioteca.repository;

import com.hygorp.biblioteca.domain.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}
