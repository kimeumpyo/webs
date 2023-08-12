package controllers.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/join")
    public String join(@ModelAttribute JoinForm joinForm){
//        model.addAttribute("joinFrom", new JoinForm());
        return "member/join";
    }
    @PostMapping("/join")
    public String joinPs(JoinForm form, Errors errors){
        joinValidator.validate(form, errors);

        if(errors.hasErrors()){
            return "member/join";
        }

        return "redirect:/member/login";
    }
}
