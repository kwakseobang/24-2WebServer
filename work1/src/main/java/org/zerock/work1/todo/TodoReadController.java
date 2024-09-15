package org.zerock.work1.todo;

import org.zerock.work1.todo.dto.TodoDTO;
import org.zerock.work1.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.lang.Long.parseLong;

@WebServlet(name = "todoReadController", urlPatterns = "/todo/read")
public class TodoReadController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/read");
        // 브라우저의 주소창을 통해서 전달되는 tno라는 이름의 파라미터 처리
        //반환이 항상 문자열이라 Long타입으로 처리
        // /todo/read?tno=123
        Long tno = parseLong(req.getParameter("tno"));
        // 가져온 TodoDTO 객체는 dto라는 이름으로 JSP에 전달
        TodoDTO dto = TodoService.INSTANCE.get(tno);
        req.setAttribute("dto",dto);

        req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req,resp);
    }
}
