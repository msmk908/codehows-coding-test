package com.example.codingtestproject.dto;

import com.example.codingtestproject.domain.Portfolio;
import lombok.Getter;

@Getter
public class PortfolioResponse {

    private final String title;
    private final String name;
    private final String profileIamge;
    private final String phoneNum;
    private final String email;
    private final String oneLineContent;
    private final String stack;
    private final String content;

    public PortfolioResponse(Portfolio portfolio){
        this.title = portfolio.getTitle();
        this.name = portfolio.getName();
        this.profileIamge = portfolio.getProfileImage();
        this.phoneNum = portfolio.getPhoneNum();
        this.email = portfolio.getEmail();
        this.oneLineContent = portfolio.getOneLineContent();
        this.stack = portfolio.getStack();
        this.content = portfolio.getContent();
    }
}
