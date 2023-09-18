package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dto.LoginDTO;

@Controller
public class LoginController {

	@GetMapping("/loginForm")
	public String home() {
		return "loginForm"; // /WEB-INF/views/loginForm.jsp 로 포워드 요청된다.
	}

	@GetMapping("/login")
	public String login(LoginDTO dto, HttpSession session) {

		// 저장된 데이터 이용해서 DB 연동해서 검증
		// 세션에 저장
		session.setAttribute("login", dto);
		return "login"; // /WEB-INF/views/login.jsp
	}

	@GetMapping("/loginCheck/logout")
	public String logout(HttpSession session) {
		// 로그인 체크 여부 확인
		LoginDTO dto = (LoginDTO) session.getAttribute("login");
		if (dto == null) {
			return "redirect:loginForm";
		} else {
			session.invalidate();
			return "main";
		}
	}

	@GetMapping("/loginCheck/mypage")
	public String mypage() {

		return "main";
	}

}
