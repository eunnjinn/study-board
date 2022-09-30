package com.example.studyboard.domain.post;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponse {

    private Long post_idx;            //게시글인덱스
    private String user_id;             //사용자아이디
    private String title;               //제목
    private String content;             //내용
    private String name;                //사용자이름
    private Boolean ncode;                   //공지코드
    private Boolean deleteYn;              // 삭제 여부
    private LocalDateTime createdDate;     // 생성일시
    private LocalDateTime modifiedDate;    // 최종 수정일시

}
