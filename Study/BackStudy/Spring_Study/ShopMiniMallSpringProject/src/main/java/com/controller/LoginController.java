package com.controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dto.MemberDTO;
import com.service.MemberService;

@Controller
public class LoginController {

	@Autowired
	MemberService service;

	// view만 보여 줄 때 , servlet-context.xml에서 구현가능
	// <mvc:view-controller path="/LoginUIServlet" view-name="loginForm"/>와 동일
//	@GetMapping("/LoginUIServlet")
//	public String loginUI() {
//		return "loginForm";
//	} 

	@GetMapping("/LoginServlet")
	public String login(@RequestParam HashMap<String, String> map, HttpSession session) {

		MemberDTO dto = service.login(map);
		String nextPage = null;
		if (dto != null) {
			session.setAttribute("login", dto);
			nextPage = "redirect:main"; // /WEB-INF/views/main.jsp
		} else {
			nextPage = "member/loginFail"; // /WEB-INF/views/member/loginFail.jsp
		}
		return nextPage;
	}

	@GetMapping("/LogoutServlet")
	public String logout(HttpSession session) {

		MemberDTO dto = (MemberDTO) session.getAttribute("login");
		session.invalidate(); // 로그아웃
		return "redirect:main";
	}
}
