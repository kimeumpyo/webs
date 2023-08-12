package controllers.member;

import models.member.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller@RequestMapping("/member2")
public class Member2Controller {
    @GetMapping("/info")
    public String info(Model model){
        Users users = Users.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("12345678")
                .userNm("사용자01")
                .mobile("01000000000")
                .regDt(LocalDateTime.now())
                .build();

        model.addAttribute("users", users);

        model.addAttribute("title", "<h1>제목!</h1>");
        return "member/info";
    }
    @GetMapping("/list")
    public String list(Model model){

        List<Users> items = new ArrayList<>();
        for(int i = 1; i<= 10; i++){
            Users users = Users.builder()
                    .userNo(i)
                    .userId("user" + i)
                    .userPw("123456")
                    .userNm("사용자" + i)
                    .mobile("01000000000")
                    .regDt(LocalDateTime.now())
                    .build();
            items.add(users);
        }
        model.addAttribute("items", items);
        model.addAttribute("menuCode", "board");
        return "member/list";
    }
    @GetMapping("/info2")
    public String info2(Model model) {
        String[] addCss = {"member/testcss1", "member/testcss2"};
        List<String> addScript = Arrays.asList("member/testjs1", "member/testjs2");

        model.addAttribute("addCss", addCss);
        model.addAttribute("addScript", addScript);
        model.addAttribute("pageTitle", "회원정보!!");

        return "member/info3";
    }
}
