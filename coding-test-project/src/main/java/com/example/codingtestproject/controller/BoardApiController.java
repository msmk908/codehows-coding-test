package com.example.codingtestproject.controller;

import com.example.codingtestproject.domain.Board;
import com.example.codingtestproject.domain.User;
import com.example.codingtestproject.dto.BoardRequest;
import com.example.codingtestproject.repository.UserRepository;
import com.example.codingtestproject.service.BoardService;
import com.example.codingtestproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Controller
public class BoardApiController {

    private final BoardService boardService;
    private final UserService userService;

    @PostMapping("/saveBoard")
    public ResponseEntity<Board> saveBoard(@RequestBody BoardRequest boardRequest) {
        // BoardRequest 클래스는 이름과 내용을 가진 DTO입니다.
        // 필요에 따라서 BoardRequest를 만들어서 사용하거나, Map<String, Object>로 받아도 됩니다.

        String name = boardRequest.getName();
        String content = boardRequest.getContent();

        // 현재 시간을 가져오기
        LocalDateTime now = LocalDateTime.now();

        // Board 객체 생성 및 데이터베이스에 저장
        Board board = new Board();
        board.setName(name);
        board.setContent(content);
        board.setCreatetime(now); // 생성 시간 설정
        boardService.save(board);

        return new ResponseEntity<>(board, HttpStatus.CREATED);
    }
}
