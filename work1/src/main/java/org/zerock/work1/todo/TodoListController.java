package org.zerock.work1.todo;


import org.zerock.work1.todo.dto.TodoDTO;
import org.zerock.work1.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/todo/list");
        // TodoSercice에서 제공하는 List<TodoDTO> 가져옴.
        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();
        // 키와 값의 형식으로 HttpServletRequest에 데이터를 보관한다. 이렇게 보관된 데이터는 JSP에서 꺼내서 사용하게 되는 방식(EL로 확인)
        // list라는 이름으로  List<TodoDTO> 객체 보관
        req.setAttribute("list", dtoList);

        req.getRequestDispatcher("/WEB-INF/todo/list.jsp")
                .forward(req,resp);
    }
}
