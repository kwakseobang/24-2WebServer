package org.zerock.work1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "myServlet", urlPatterns = "/my") // 브라우저의 경로와 해당 서블릿을 연결하는 설정
public class MyServlet extends HttpServlet {
    @Override //브라우저의 주소를 직접 변경해서 접근하는 경우에 호출되는 메소드
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {

        resp.setContentType("text/html");
        // 브라우저쪽으로 출력
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>MyServlet</h1>");
        out.println("</body></html>");


    }
}
