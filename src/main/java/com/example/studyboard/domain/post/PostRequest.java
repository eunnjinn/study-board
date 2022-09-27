package com.example.studyboard.domain.post;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostRequest {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private Boolean noticeYn;
}
