package com.example.studyboard.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {
    @RequestMapping("/")
    public String Hello(){
        return "helvvlod";
    }
}
