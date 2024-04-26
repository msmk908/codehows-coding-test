package com.example.codingtestproject.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Table(name = "portfolios")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Portfolio {

    @Id // 기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가
    @Column(name = "portfolio_id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "profileimage", nullable = false)
    private String profileImage;

    @Column(name = "phonenum", nullable = false)
    private String phoneNum;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "onelinecontent", nullable = false)
    private String oneLineContent;

    @Column(name = "stack", nullable = false)
    private String stack;

    @Column(name = "content", nullable = false)
    private String content;

    /*@CreatedDate // 엔티티가 생성될 때 생성 시간 저장
    @Column(name = "create_time")
    private LocalDateTime createTime;

    @LastModifiedDate // 엔티티가 수정될 때 수정 시간 저장
    @Column(name = "update_time")
    private LocalDateTime updateTime;*/

    @Builder
    public Portfolio(String title, String name,
                     String profileImage, String phoneNum,
                     String email, String oneLineContent,
                     String stack, String content){
        this.title = title;
        this.name = name;
        this.profileImage = profileImage;
        this.phoneNum = phoneNum;
        this.email = email;
        this.oneLineContent = oneLineContent;
        this.stack = stack;
        this.content = content;
    }

    // 포트폴리오 수정
    public void update(String title, String name,
                       String profileImage, String phoneNum,
                       String email, String oneLineContent,
                       String stack, String content){
        this.title = title;
        this.name = name;
        this.profileImage = profileImage;
        this.phoneNum = phoneNum;
        this.email = email;
        this.oneLineContent = oneLineContent;
        this.stack = stack;
        this.content = content;
    }

}
