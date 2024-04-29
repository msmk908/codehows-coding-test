package com.example.codingtestproject.controller;

import com.example.codingtestproject.domain.Board;
import com.example.codingtestproject.domain.User;
import com.example.codingtestproject.service.BoardService;
import com.example.codingtestproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardViewController {

    private final BoardService boardService;
    private final UserService userService;

    @GetMapping("/board")
    public String board(Model model) {
        List<Board> boards = boardService.getAllBoards();

        // 현재 로그인한 사용자의 이메일 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();

        // 사용자의 이름 가져오기
        User user = userService.findByEmail(userEmail);
        String userName = user.getName();

        // 모델에 게시물 리스트와 사용자 이름 추가
        model.addAttribute("boards", boards);
        model.addAttribute("userName", userName);

        return "board"; // Thymeleaf 템플릿 이름
    }

    @GetMapping("/newBoard")
    public String newBoard(){ return "newBoard"; }

}
