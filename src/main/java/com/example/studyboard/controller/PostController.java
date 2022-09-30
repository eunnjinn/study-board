package com.example.studyboard.controller;

import com.example.studyboard.domain.post.PostRequest;
import com.example.studyboard.domain.post.PostResponse;
import com.example.studyboard.domain.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    //게시글 작성
    @GetMapping("/post/write.do")
    public String openPostWrite(@RequestParam(value = "post_idx", required = false) final Long post_idx, Model model) {
        if (post_idx != null) {
            PostResponse post = postService.findByPostIdx(post_idx);
            model.addAttribute("post", post);
        }
        return "post/write";
    }

    @PostMapping("/post/save.do")
    public String savePost(final PostRequest params) {
        postService.savePost(params);
        return "redirect:/post/list.do";
    }

    // 게시글 리스트 페이지
    @GetMapping("/post/list.do")
    public String openPostList(Model model) {
        List<PostResponse> posts = postService.findAllPost();
        model.addAttribute("posts", posts);
        return "post/list";
    }


    // 게시글 상세 페이지
    @GetMapping("/post/view.do")
    public String openPostView(@RequestParam final Long post_idx, Model model) {
        PostResponse post = postService.findByPostIdx(post_idx);
        model.addAttribute("post", post);
        return "post/view";
    }
}
