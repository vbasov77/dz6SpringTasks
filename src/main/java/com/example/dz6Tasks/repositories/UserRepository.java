package com.example.dz6Tasks.repositories;

import com.example.dz6Tasks.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findUserById(Long id);
    List<User> findAll();
}