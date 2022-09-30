package com.example.studyboard;

import com.example.studyboard.domain.post.PostRequest;
import com.example.studyboard.domain.post.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostServiceTest {

    @Autowired
    PostService postService;

    @Test
    void save(){
        PostRequest params = new PostRequest();
        params.setUser_id("eunjin");
        params.setTitle("게시글제목");
        params.setContent("내용");
        params.setName("테스터");
        params.setNcode(true);
        postService.savePost(params);

    }

}
