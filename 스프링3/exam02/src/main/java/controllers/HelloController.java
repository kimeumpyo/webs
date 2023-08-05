package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
//    검색
    @GetMapping("/hello")
    public String hello(){
        return "hello"; // 경로 -> /WEB-INF/view/hello.jsp
    }
}
