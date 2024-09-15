package org.zerock.work1.calc;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InputController", urlPatterns = "/calc/input")
public class InputController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("InputController.. doGet..");
        // RequestDispatcher 는 서블릿에 전달된 요청을 다른 쪽으로 전달 혹은 배포 하는 역할을 하는 객체
        // WEB-INF 는 브라우저에서 직접 접근이 불가능한 경로. WEB-INF 밑에 jsp 파일을 둔다는 의미는 브라우저에서 jsp로 직접 호출 불가능
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/calc/input_mvc.jsp");

        dispatcher.forward(req,resp);
    }
}
