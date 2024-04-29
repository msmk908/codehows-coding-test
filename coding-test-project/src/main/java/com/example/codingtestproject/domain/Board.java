package com.example.codingtestproject.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Table(name = "boards")
@Entity
@Getter @Setter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 자동으로 1씩 증가
    @Column(name = "board_id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content", nullable = false)
    private String content;

    @CreatedDate // 엔티티가 생성될 때 생성 시간 저장
    @Column(name = "createtime")
    private LocalDateTime createtime;

    @LastModifiedDate // 엔티티가 수정될 때 수정 시간 저장
    @Column(name = "updatetime")
    private LocalDateTime updatetime;

    @Builder
    public Board(String name, String content){
        this.name = name;
        this.content = content;
    }

}
