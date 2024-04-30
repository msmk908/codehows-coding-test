package com.example.codingtestproject.dto;

import com.example.codingtestproject.domain.Portfolio;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor // 모든 필드 값을 파라미터로 받는 생성자 추가
@Getter
public class AddPortfolioRequest {

    private String title;
    private String name;
    private String profileimage;
    private String phonenum;
    private String email;
    private String onelinecontent;
    private String stack;
    private String content;

}
