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
        params.setUid("jin");
        params.setTitle("No.2 Post Title");
        params.setContent("No.2 Post Content");
        params.setName("Tester");
        params.setNcode(false);
        postMapper.save(params);

        List<PostResponse> posts = postMapper.findAll();
        System.out.println("ㅇㅇㅇㅇㅇThe total number of Post: " + posts.size() + ".");
    }

    @Test
    void findById(){
        PostResponse post = postMapper.findById(1L);
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
        params.setId(1L);
        params.setUid("jang");
        params.setTitle("No.1 title modify");
        params.setContent("content modify");
        params.setName("tester2");
        params.setNcode(false);
        postMapper.update(params);

        PostResponse post = postMapper.findById(1L);
        try{
            String postJson = new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(post);
            System.out.println(postJson);

        }catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }

    @Test
    void delete(){
        System.out.println("===Total posts before deletion: " + postMapper.findAll().size() + ".");
        postMapper.deleteById(1L);
        System.out.println("====Total posts after deletion: " + postMapper.findAll().size() + ".");
    }
}
