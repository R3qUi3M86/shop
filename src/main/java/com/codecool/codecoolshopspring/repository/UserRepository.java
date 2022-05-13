package com.codecool.codecoolshopspring.repository;

import com.codecool.codecoolshopspring.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
