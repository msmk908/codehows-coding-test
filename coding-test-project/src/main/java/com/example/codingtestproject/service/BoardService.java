package com.example.codingtestproject.service;

import com.example.codingtestproject.domain.Board;
import com.example.codingtestproject.domain.Portfolio;
import com.example.codingtestproject.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public void save(Board board) {
        boardRepository.save(board);
    }

    public List<Board> getAllBoards(){
        return boardRepository.findAll();
    }

}
