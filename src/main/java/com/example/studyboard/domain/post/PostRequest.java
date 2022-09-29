package com.example.studyboard.domain.post;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PostRequest {
    private Long post_idx;
    private String user_id;
    private String title;
    private String content;
    private String name;
    private int code;
}
