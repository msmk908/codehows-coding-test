package com.example.codingtestproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdatePortfolioRequest {
    private String title;
    private String name;
    private String profileImage;
    private String phoneNum;
    private String email;
    private String oneLineContent;
    private String stack;
    private String content;
}
