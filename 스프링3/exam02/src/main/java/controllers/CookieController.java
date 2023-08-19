package controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cookie")
public class CookieController {
    @Autowired
    private HttpServletResponse response;

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/test1")
    public String test1(){
        Cookie cookie1 = new Cookie("key1", "value1");
        // 쿠키(HttpOnly)체크 콘솔에서 document.cookie 조회불가능 설정!
        cookie1.setHttpOnly(true);
        // 초(sec)단위
        cookie1.setMaxAge(60 * 60 * 24 * 7);// 1주일후!
        response.addCookie(cookie1); // 응답 헤더 : Set-Cookie: key1 = value1

        Cookie cookie2 = new Cookie("key2", "value2");
        response.addCookie((cookie2));


        return "cookie/test";
    }
    @GetMapping("/test2")
    public String test2(@CookieValue(name = "key2", required = false, defaultValue = "없음") String key2){
        System.out.println("key2 : " + key2);
        /*
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.printf("name=%s, value=%s%n", name, value);
            if(name.equals("key2")){
                //
            }
        }
        */

        return "cookie/test";
    }
    @GetMapping("/test3")
    public String test3(){
        Cookie cookie = new Cookie("key1", "value1");
        cookie.setMaxAge(0);
        response.addCookie(cookie);

        return "cookie/test";
    }
    @GetMapping("/test4")
    public String test4(HttpSession session){
        session.setAttribute("sess1", "값1");
        return "cookie/test";
    }
    @GetMapping("/test5")
    public String test5(HttpSession session){
        String value = (String)session.getAttribute("sess1");
        System.out.println(value);
        return "cookie/test";
    }
}
