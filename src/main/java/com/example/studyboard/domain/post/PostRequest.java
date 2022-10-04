package com.example.studyboard.domain.post;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostRequest {
    private Long id;
    private String uid;
    private String title;
    private String content;
    private String name;
    private Boolean ncode;
}
