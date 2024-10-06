package org.zerock.w2.filter;

import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

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

        //session에 loginInfo 값이 없다면 쿠키를 체크
        Cookie cookie = findCookie(req.getCookies(),"remember-me");

        //session에도 없고 cookie에도 없다면 그냥 로그인 창으로
        if(cookie == null) {
            resp.sendRedirect("/login");
            return;
        }

        // 쿠키가 존재하는 상황이라면
        log.info("cookie는 존재하는 상황");
        //uuid 값
        String uuid = cookie.getValue();

        try {
            // DB 확인
            MemberDTO memberDTO = MemberService.INSTANCE.getByUUID(uuid);

            log.info("쿠키의 값으로 조회한 사용자 정보: " + memberDTO);
            if(memberDTO == null) {
                throw new Exception(("Cookie value is Not Vaild..."));
            }
            // 회원 정보에 세션 추가
            session.setAttribute("loginInfo",memberDTO);
            // 다음 필터나 목적지로 갈 수 있도록 하는 메서드
            chain.doFilter(request,response);
        }catch (Exception e) {
                e.printStackTrace();
                resp.sendRedirect("/login");
        }

    }


    private Cookie findCookie(Cookie[] cookies, String name) {
        if(cookies == null || cookies.length == 0) {
            return null;
        }

        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(ck -> ck.getName().equals(name))
                .findFirst();

        return  result.isPresent() ? result.get() : null;

    }
}
