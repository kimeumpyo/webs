package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet2 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.print("<form method='POST'>");
        out.print("제목 : <input type='text' name='subject'><br>");
        out.print("내용 : <textarea name='content'></textarea><br>");
        out.print("<button type='submit'>작성하기</button>");
        out.print("</form>");
        // -> req
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8"); // servlet 4,
        String subject = req.getParameter("subject");
        String content = req.getParameter("content");

        System.out.printf("제목:%s, 내용:%s%n", subject, content);
    }
}
