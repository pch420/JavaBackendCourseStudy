package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	// redirect 요청
	@RequestMapping("/aaa")
	public String aaa(Model m) {
		System.out.println("aaa 호출");
		m.addAttribute("userid", "홍길동");
		// 이전 서블릿 : response.sendRedirect("xxx") 동일
		return "redirect:xxx";
	}

	// forward 요청
	@RequestMapping("/bbb")
	public String bbb(Model m) {
		System.out.println("bbb 호출");
		m.addAttribute("userid", "이순신");
		// 이전 서블릿 : request.getRequestDispatcher("xxx").forward(request,response) 동일
		return "forward:xxx";
	}

	@RequestMapping("/xxx")
	public String main() {
		System.out.println("main 호출");
		return "main";
	}

}
