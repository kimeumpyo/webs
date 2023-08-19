package config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;
public class MemberOnlyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // HttpServletRequest - HttpSession getSession()

        request.setAttribute("commonData", "공통 데이터!");

        HttpSession session = request.getSession();
        if(session.getAttribute("user") != null){ // 로그인 상태
            return true;
        }
        // 미로그인 상태 - 외원 전용 서비스를 사용하기 위해 로그인 페이지로 이동
        response.sendRedirect(request.getContextPath()+ "/member3/login");
        return false;
    }
}
