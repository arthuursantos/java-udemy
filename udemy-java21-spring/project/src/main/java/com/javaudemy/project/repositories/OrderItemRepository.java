package com.javaudemy.project.repositories;

import com.javaudemy.project.entities.OrderItem;
import com.javaudemy.project.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}