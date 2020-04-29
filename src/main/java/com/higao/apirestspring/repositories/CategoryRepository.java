package com.higao.apirestspring.repositories;

import com.higao.apirestspring.entities.Category;
import com.higao.apirestspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
