package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/todo/*"})
@Log4j2
public class LoginCheckFilter implements Filter {

    // 필터링이 필요한 로직 구현
    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain
    ) throws IOException, ServletException {

        log.info("Login check filter");
        // Filter 인터페이스의 doFilter()는 HttpServletRequest,HttpServletResponse 보다 상위 타입의 파라미터를 사용하므로
        // Http와 관련된 작업을 하려면 다운캐스팅을 해줘야 함.
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        // filter를 통해 null일시 로그인 창으로 이동.
        if(session.getAttribute("loginInfo") == null) {
            resp.sendRedirect("/login");
            return;
        }
        // 다음 필터나 목적지로 갈 수 있도록 하는 메서드
        chain.doFilter(request,response);

    }
}
