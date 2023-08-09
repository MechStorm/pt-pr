package com.example.spring_boot_exp.repositories;

import com.example.spring_boot_exp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
