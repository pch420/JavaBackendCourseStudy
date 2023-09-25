package com.exam.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeptController {

	// application.properties에 저장된 값을 가져오기
	@Value("${server.port}")
	String port;

	@GetMapping("/main")
	public String main() {
		System.out.println("DeptController" + port);
		return "hello";
	}
}
