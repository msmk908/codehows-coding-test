package com.example.codingtestproject.repository;

import com.example.codingtestproject.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
