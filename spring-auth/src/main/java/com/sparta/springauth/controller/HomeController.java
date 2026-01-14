package com.sparta.springauth.controller;

import com.sparta.springauth.jwt.JwtUtil;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final JwtUtil jwtUtil;

    // JwtUtil을 주입받습니다.
    public HomeController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/")
    public String home(HttpServletRequest req, Model model) {
        // 1. 쿠키에서 토큰 가져오기
        String tokenValue = jwtUtil.getTokenFromRequest(req);

        if (tokenValue != null) {
            // 2. "Bearer " 접두사 제거
            String token = jwtUtil.substringToken(tokenValue);

            // 3. 토큰 검증
            if (jwtUtil.validateToken(token)) {
                // 4. 토큰에서 사용자 정보(Claims) 추출
                Claims info = jwtUtil.getUserInfoFromToken(token);

                // 5. 실제 사용자 이름을 Model에 담기
                model.addAttribute("username", info.getSubject());
            }
        }

        return "index";
    }
}