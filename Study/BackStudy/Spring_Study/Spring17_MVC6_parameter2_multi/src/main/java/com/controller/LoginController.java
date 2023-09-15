package com.controller;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.dto.LoginDTO;

@Controller
public class LoginController {

	@GetMapping("/loginForm")
	public String home() {
		System.out.println("LoginController.home 메서드");
		return "loginForm"; // /WEB-INF/views/loginForm.jsp 로 포워드 요청된다.
	}
	
	@GetMapping("/login")
	public String login(LoginDTO dto) {
		System.out.println(dto);
		return "loginForm"; 
	}

	@GetMapping("/login2")
	public String login2(HttpServletRequest request) {
		// 사용자 입력 데이터 얻기
		System.out.println("LoginController.get-login 메서드");
		String userid = request.getParameter("userid");
		String passwd = request.getParameter("passwd");

		String[] phone = request.getParameterValues("phone");
		String[] email = request.getParameterValues("email");

		System.out.println(userid + " " + passwd);
		System.out.println(Arrays.toString(phone) + " " + Arrays.toString(email));
		return "loginForm";
	}

}
