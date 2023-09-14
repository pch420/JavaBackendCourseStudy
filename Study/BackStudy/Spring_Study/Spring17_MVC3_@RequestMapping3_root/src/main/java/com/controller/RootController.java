package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/board")
public class RootController {

	// http://localhost:8090/app/board/add
	@RequestMapping(value = "/add")
	public String add() {
		System.out.println("RootController.add");
		return "/WEB-INF/views/main.jsp";
	}

	// http://localhost:8090/app/board/del
	@RequestMapping(value = "/del")
	public String del() {
		System.out.println("RootController.del");
		return "/WEB-INF/views/main.jsp";
	}

}
