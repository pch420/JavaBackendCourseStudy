package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

	// 1. 맵핑값 하나
	// http://localhost:8090/app/xxx
	@RequestMapping(value = "/xxx")
	public String xxx() {
		System.out.println("TestController.xxx");
		return "/WEB-INF/views/main.jsp";
	}

	// 2. 맴핑값 두개
	// http://localhost:8090/app/xxx2
	// http://localhost:8090/app/xxx3
	@RequestMapping({ "/xxx2", "/xxx3" })
	public String xxx2_3() {
		System.out.println("TestController.xxx2_3");
		return "/WEB-INF/views/main.jsp";
	}

	// 3. 특정값으로 시작
	// http://localhost:8090/app/yyyA
	// http://localhost:8090/app/yyyABC
	// http://localhost:8090/app/yyy/xxx (X) 경로는 들어가면 못찾음
	@RequestMapping("/yyy*")
	public String yyy() {
		System.out.println("TestController.yyy");
		return "/WEB-INF/views/main.jsp";
	}

	// 4. 특정경로 하나
	// http://localhost:8090/app/zzz/aaa
	// http://localhost:8090/app/zzz/bbb
	// http://localhost:8090/app/zzz/aaa/ccc (X)
	@RequestMapping(value = "/zzz/*")
	public String zzz() {
		System.out.println("TestController.zzz");
		return "/WEB-INF/views/main.jsp";
	}

	// 5. 특정 경로 여러개
	// http://localhost:8090/app/kkk
	// http://localhost:8090/app/kkk/aaa
	// http://localhost:8090/app/kkk/bbb
	// http://localhost:8090/app/kkk/aaa/ccc
	@RequestMapping(value = "/kkk/**")
	public String kkk() {
		System.out.println("TestController.kkk");
		return "/WEB-INF/views/main.jsp";
	}

	// 6. 경로중간에 패턴지정
	// http://localhost:8090/app/eee/임의값/fff
	@RequestMapping(value = "/eee/**/fff")
	public String eee() {
		System.out.println("TestController.eee");
		return "/WEB-INF/views/main.jsp";
	}

}
