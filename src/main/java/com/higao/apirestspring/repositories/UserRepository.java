package com.higao.apirestspring.repositories;

import com.higao.apirestspring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
