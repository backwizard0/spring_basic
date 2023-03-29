package com.fastcampus.spring_basic.ch2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/board")
public class BoardController {
    @GetMapping("/list")
    public String list(HttpServletRequest request){
        if (!logCheck(request))
            return "redirect:/login/login?toURL="+request.getRequestURL(); // 로그인을 안햇으면 로그인 화면으로 이동

        return "boardList"; // 로그인을 한 상태이면, 게시판 화면으로 이동
    }

    private boolean logCheck(HttpServletRequest request){
        // 1. 세션을 얻어서
        HttpSession session = request.getSession();
        // 2. 세션에 id가 있는지 확인
//        if (session.getAttribute("id")!=null)
//            return true;
//        else
//            return false;

        return session.getAttribute("id")!=null;
    }
}