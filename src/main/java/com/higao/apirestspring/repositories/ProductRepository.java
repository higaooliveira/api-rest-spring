package com.higao.apirestspring.repositories;

import com.higao.apirestspring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
