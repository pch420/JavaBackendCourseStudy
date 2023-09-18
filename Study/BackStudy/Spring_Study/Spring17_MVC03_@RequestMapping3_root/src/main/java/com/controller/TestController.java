package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	// http://localhost:8090/app/member/add
	@RequestMapping(value = "/member/add")
	public String add() {
		System.out.println("TestController.add");
		return "/WEB-INF/views/main.jsp";
	}

	// http://localhost:8090/app/member/del
	@RequestMapping(value = "/member/del")
	public String del() {
		System.out.println("TestController.del");
		return "/WEB-INF/views/main.jsp";
	}

}
