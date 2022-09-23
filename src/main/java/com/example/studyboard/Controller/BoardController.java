package com.example.studyboard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/**") // /board로 접근하는 url처리를 이 클래스인 boardController에서 맡는다고 알려줌
public class BoardController {

    @GetMapping("/hello")
    public String Hello(){
        return "/boards/hello";
    }
}
