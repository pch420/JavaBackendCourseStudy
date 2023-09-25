package com.exam.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.exam.dto.DeptDTO;

@Controller
public class TestController {

	@GetMapping("/main")
	public String main() {
		return "main";
	}

	// String 반환
	@GetMapping(value = "/aaa", produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String aaa() {
		return "홍길동";
	}

	// DeptDTO 반환(JSON)
	@GetMapping(value = "/bbb")
	@ResponseBody
	public DeptDTO bbb() {
		DeptDTO dto = new DeptDTO(10, "개발", "서울");
		return dto;
	}

	// List 반환(JSON)
	@GetMapping(value = "/ccc")
	@ResponseBody
	public ArrayList<DeptDTO> ccc() {
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		list.add(new DeptDTO(10, "개발1", "서울"));
		list.add(new DeptDTO(20, "개발2", "서울"));
		list.add(new DeptDTO(30, "개발3", "서울"));
		return list;
	}

	// html 반환
	@GetMapping(value = "/ddd", produces = "text/html;charset=utf-8") // ddd() 에서 만든 string을 html로 응답
	@ResponseBody
	public String ddd() {
		return "<html><body><h1>Hello</h1></body></html>";
	}
	
	// xml 반환
	@GetMapping(value = "/eee", produces = "text/xml;charset=utf-8") // eee() 에서 만든 string을 xml로 응답
	@ResponseBody
	public String eee() {
		return "<person><name>홍길동</name><age>20</age></person>";
	}

}
