package models.member;

import controllers.member.LoginForm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final UserDao userDao;
    private final HttpSession session;
    private final HttpServletResponse response;
    public void login(LoginForm loginForm){
        String userId = loginForm.getUserId();

        Users user = userDao.get(userId);
        session.setAttribute("user", user); // 로그인 처리

        //    아이디 쿠키 저장 처리
        Cookie saveId = new Cookie("saveId", userId);
        if (loginForm.isSaveId()){ // 아이디 저장
            saveId.setMaxAge(60 * 60 * 24 * 365); // 1년동안 기억!
        }else{// 아이디 삭제
            saveId.setMaxAge(0); // 만료시 삭제!
        }
        response.addCookie(saveId);
    }


}
