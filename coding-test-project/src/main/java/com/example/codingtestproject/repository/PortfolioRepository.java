package com.example.codingtestproject.repository;

import com.example.codingtestproject.domain.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {
    List<Portfolio> findByMainTrue();
}
