package controllers.member;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member3")
@RequiredArgsConstructor
public class Member3Controller {
    //    @Autowired
    private final JoinValidator joinValidator;

//    또는

    //    public Member3Controller(JoinValidator joinValidator){
//        this.joinValidator = joinValidator;
//    }
    private final JoinService joinService;
    private final LoginValidator loginValidator;
    private final LoginService loginService;

    @GetMapping("/join")
    public String join(@ModelAttribute JoinForm joinForm) {
//        model.addAttribute("joinFrom", new JoinForm());
        return "member/join";
    }

    @PostMapping("/join")
    // 에러 객체는 항상 뒤에 배치해야 동작한다!
    public String joinPs(@Valid JoinForm form, Errors errors) {
        joinValidator.validate(form, errors);

        if (errors.hasErrors()) {
            return "member/join";
        }
        // 회원 가입 처리
        joinService.join(form);

        return "redirect:/member/login";
    }
    @GetMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, @CookieValue(required = false) String saveId){
        if(saveId != null){
            loginForm.setUserId(saveId);
            loginForm.setSaveId(true);
        }
        return "member/login";
    }
    @PostMapping("/login")
    public String loginPs(@Valid LoginForm loginForm, Errors errors){

        loginValidator.validate(loginForm, errors);

        if(errors.hasErrors()){
            return "member/login";
        }
        // 로그인 처리
        loginService.login(loginForm);

        return "redirect:/";
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate(); // 세션 비우기 -> 로그아웃

        return "redirect:/member3/login";
    }

    /*
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.setValidator(new JoinValidator());
    }
    */
}
