package com.example.codingtestproject.dto;

import com.example.codingtestproject.domain.Portfolio;
import lombok.Getter;

@Getter
public class PortfolioListViewResponse {

    private final Long id;
    private final String title;
    private final String name;
    private final String profileimage;
    private final String phonenum;
    private final String email;
    private final String onelinecontent;
    private final String stack;
    private final String content;

    public PortfolioListViewResponse(Portfolio portfolio){

        this.id = portfolio.getId();
        this.title = portfolio.getTitle();
        this.name = portfolio.getName();
        this.profileimage = portfolio.getProfileimage();
        this.phonenum = portfolio.getPhonenum();
        this.email = portfolio.getEmail();
        this.onelinecontent = portfolio.getOnelinecontent();
        this.stack = portfolio.getStack();
        this.content = portfolio.getContent();
    }
}
