package org.zerock.w2.controller;


import lombok.extern.java.Log;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
@Log
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            log.info("login get.............");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("login post.............");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        String auto = req.getParameter("auto");
        //체크박스가 체크 됐으면 true
        boolean rememberMe = auto != null && auto.equals("on");


        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid,mpw);

            //체크박스가 체크 됐으면 임의의 번호 생성
            if(rememberMe) {
                String uuid = UUID.randomUUID().toString();

                MemberService.INSTANCE.updateUuid(mid,uuid);
                memberDTO.setUuid(uuid);

                //쿠키 생성 및 전송
                Cookie rememberCookie = new Cookie("remember-me",uuid);
                rememberCookie.setMaxAge(60*60*24*7);
                rememberCookie.setPath("/");

                resp.addCookie(rememberCookie); // 전송
            }

            HttpSession session = req.getSession();
            session.setAttribute("loginInfo",memberDTO);
            resp.sendRedirect("/todo/list");

        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
        }






    }
}
