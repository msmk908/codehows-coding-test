package com.example.codingtestproject.dto;

public class BoardRequest {
    private String name;
    private String content;

    // 생성자, getter 및 setter 메서드
    public BoardRequest() {}

    public BoardRequest(String name, String content) {
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

