package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
// 참고
// https://jakarta.ee/specifications/servlet/5.0/apidocs/jakarta/servlet/http/httpservlet

public class MyServlet1 extends HttpServlet {
    // Jenerate -> Override Methods -> doGet
    // ctrl + o 단축키

    // web.xml
    // 주소 -> 서블릿 클래스 -> 서블릿 객체

    // 요청 정보
    // HttpServletRequest(요청) 구현객체 -> req
    // HttpServletResponse(응답) 구현객체 -> resp
    // 호출

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 요청 정보를 분석 -> 필요한 자원을 찾거나 가공 -> 응답
//        resp.setContentType("text/html"); // Content-Type : text/html
//        resp.setCharacterEncoding("UTF-8");

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<h1>안녕하세요!</h1>");

    }
}
