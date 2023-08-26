package org.koreait.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/") // 메인페이지
    public String index(){
        System.out.println("테스트");
         return "index";
    }
}
