package com.higao.apirestspring.repositories;

import com.higao.apirestspring.entities.Category;
import com.higao.apirestspring.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
