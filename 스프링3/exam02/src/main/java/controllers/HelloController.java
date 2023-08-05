package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
//    검색
    @GetMapping("/hello")
//    required = false 필수항목이 아니다!
    public String hello(@RequestParam(value = "nm", required = false, defaultValue = "없는 이름")
                            String name, int num, boolean agree){
        System.out.printf("name=%s, num=%d, agree=%s%n",name, num, agree);
        return "hello"; // 경로 -> /WEB-INF/view/hello.jsp
    }
}
