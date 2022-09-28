package com.example.studyboard;

import com.example.studyboard.domain.post.PostMapper;
import com.example.studyboard.domain.post.PostRequest;
import com.example.studyboard.domain.post.PostResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PostMapperTest {

    @Autowired
    PostMapper postMapper;

    @Test
    void save(){
        PostRequest params = new PostRequest();
        params.setPost_idx("00001");
        params.setUser_id("jin");
        params.setTitle("No.1 Post Title");
        params.setContent("No.1 Post Content");
        params.setName("Tester");
        params.setCode(1);
        postMapper.save(params);

        List<PostResponse> posts = postMapper.findAll();
        System.out.println("ㅇㅇㅇㅇㅇThe total number of Post: " + posts.size() + ".");
    }

    @Test
    void findByPostIdx(){
        PostResponse post = postMapper.findByPostIdx("00001");
        try{
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);
        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void update(){
        //1. Modify post
        PostRequest params = new PostRequest();
    }
}
