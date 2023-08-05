package controllers.member;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
// 생성자 매개변수
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private HttpServletRequest request;

    private final HttpServletResponse response;

    @NonNull
    private HttpSession session;
    @GetMapping("/member/join")
    public String join(Model model)  {
    /*
        try {
            response.sendRedirect(request.getContextPath() + "member/login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
     */
        model.addAttribute("title", "회원가입!");
        return "member/join";
//        return "redirect:/member/login"; // 주소 /member/login으로 이동 location: /exam02/member/login
    }

    /*
    @GetMapping("/member/join")
    public String join(Model model, HttpServletResponse response,
                       HttpSession session){

        String name = request.getParameter("name");
        System.out.println(name);
        System.out.println(response);
        System.out.println(session);

        model.addAttribute("title", "제목");

        return "member/join"; // /WEB-INF/view/member/join.jsp
    }
     */
    /*
    @GetMapping("/member/join")
    public ModelAndView join(){
        ModelAndView mv = new ModelAndView();
        mv.addObject("title", "제목2");
        mv.setViewName("member/join");

        return mv;
    }
     */

    @PostMapping("/member/join")
    public String joinPs(Member member){
        System.out.println("POST로 유입!!!");
        System.out.println(member);

        return "member/join";
    }
}
