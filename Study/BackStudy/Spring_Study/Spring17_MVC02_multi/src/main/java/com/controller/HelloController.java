package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	// 요청URL : http://localhost:8090/app/xxx
	@RequestMapping("/xxx")
	public String aaa() {
		System.out.println("HelloController.aaa");
		// forward 이므로 url 변경안됨 (/xxx그대로 aaa.jsp 보여줌)
		return "/WEB-INF/views/aaa.jsp";
	}
}
