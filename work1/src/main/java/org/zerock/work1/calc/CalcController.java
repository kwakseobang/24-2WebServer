package org.zerock.work1.calc;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calcController", urlPatterns = "/calc/makeResult")
public class CalcController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String num1 = req.getParameter("num1");
        String num2 = req.getParameter("num2");

        System.out.printf(" num1: %s", num1);
        System.out.printf(" num2: %s", num2);


        //POST 방식의 처리는 가능하면 빨리 다른 페이지를 보도록 브라우저 화면을 이동시키는것이 좋다.
        //POST 방식으로 처리하고 JSP를 이ㅛㅇ해서 결과를 보여주는 방식을 이용할 떄도 처리가 끝난 후에 다른 경로로 이동하게 하는 것이 일반적이다.
        //이때 사용하는 메ㅔ소드가 HttpServletResponse의 sendRedirect이다.
        resp.sendRedirect("/index");
    }
}
