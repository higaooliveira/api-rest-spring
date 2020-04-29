package com.higao.apirestspring.repositories;

import com.higao.apirestspring.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
