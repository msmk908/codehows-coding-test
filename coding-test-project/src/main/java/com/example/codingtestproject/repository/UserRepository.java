package com.example.codingtestproject.repository;

import com.example.codingtestproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
