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
    private String profileimage;
    private String phonenum;
    private String email;
    private String onelinecontent;
    private String stack;
    private String content;
}
