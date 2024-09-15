package org.zerock.work1.todo;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "todoRegisterController", urlPatterns = "/todo/register")
public class TodoRegisterController extends HttpServlet {

    @Override //등록화면을 조회하는 경우
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("입력 화면을 볼 수 있도록 구성");
        //
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");

        dispatcher.forward(req,resp);
    }

    @Override //등록하는 경우
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("입력을 처리하고 목록 페이지로 이동");

        //브라우저가 호출해야 하는 주소
        // PRG 패턴을 적용. 브라우저를 다른 주소로 이동시키기 떄문에 사용자가 반복적인 POST 요청을 보내는 것을 막을 수 있다.
        resp.sendRedirect("/todo/list");
    }
}
