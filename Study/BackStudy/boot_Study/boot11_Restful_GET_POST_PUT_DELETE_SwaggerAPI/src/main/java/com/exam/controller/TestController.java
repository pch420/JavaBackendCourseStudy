package com.exam.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.dto.DeptDTO;

@RestController
public class TestController {

	@GetMapping("/aaa")
	public String aaa() {
		System.out.println("@GetMapping-조회용");
		return "get";
	}

	@PostMapping("/bbb")
	public String bbb() {
		System.out.println("@PostMapping-저장용");
		return "post";
	}

	@PutMapping("/ccc")
	public String ccc() {
		System.out.println("@PutMapping-수정용");
		return "put";
	}

	@DeleteMapping("/ddd")
	public String ddd() {
		System.out.println("@DeleteMapping-삭제용");
		return "delete";
	}

	// DeptDTO 반환(JSON)
	@GetMapping(value = "/xxx")
	public DeptDTO xxx() {
		DeptDTO dto = new DeptDTO(10, "개발", "서울");
		return dto;
	}

	// List 반환(JSON)
	@GetMapping(value = "/yyy")
	public ArrayList<DeptDTO> yyy() {
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		list.add(new DeptDTO(10, "개발1", "서울"));
		list.add(new DeptDTO(20, "개발2", "서울"));
		list.add(new DeptDTO(30, "개발3", "서울"));
		return list;
	}

}
