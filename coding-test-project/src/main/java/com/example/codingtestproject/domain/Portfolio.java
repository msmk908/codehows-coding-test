package com.example.codingtestproject.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Table(name = "portfolios")
@Entity
@Getter @Setter
@NoArgsConstructor
public class Portfolio {

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가
    @Column(name = "portfolio_id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "name")
    private String name;

    @Column(name = "profileimage")
    private String profileimage;

    @Column(name = "phonenum")
    private String phonenum;

    @Column(name = "email")
    private String email;

    @Column(name = "onelinecontent", nullable = false)
    private String onelinecontent;

    @Column(name = "stack", nullable = false)
    private String stack;

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate // 엔티티가 생성될 때 생성 시간 저장
    @Column(name = "createtime")
    private LocalDateTime createtime;

    @LastModifiedDate // 엔티티가 수정될 때 수정 시간 저장
    @Column(name = "updatetime")
    private LocalDateTime updatetime;

    @Column(name = "main")
    private boolean main;

    @Builder
    public Portfolio(String title, String name,
                     String profileimage, String phonenum,
                     String email, String onelinecontent,
                     String stack, String content){
        this.title = title;
        this.name = name;
        this.profileimage = profileimage;
        this.phonenum = phonenum;
        this.email = email;
        this.onelinecontent = onelinecontent;
        this.stack = stack;
        this.content = content;
    }

    // 포트폴리오 수정
    public void update(String title, String name,
                       String profileimage, String phonenum,
                       String email, String onelinecontent,
                       String stack, String content){
        this.title = title;
        this.name = name;
        this.profileimage = profileimage;
        this.phonenum = phonenum;
        this.email = email;
        this.onelinecontent = onelinecontent;
        this.stack = stack;
        this.content = content;
    }

}
