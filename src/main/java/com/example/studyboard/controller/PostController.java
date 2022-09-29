package com.example.studyboard.controller;

import com.example.studyboard.domain.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    //게시글 작성
    @GetMapping("/post/write.do")
    public String openPostWrite(Model model){
        String title = "제목",
                content = "내용",
                name = "은진";
        model.addAttribute("t", title);
        model.addAttribute("c", content);
        model.addAttribute("n",name);

        return "post/write";
    }

}
